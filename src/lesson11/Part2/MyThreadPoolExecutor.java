package lesson11.Part2;

import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
// import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadPoolExecutor {

    private final int corePoolSize;
    private final BlockingQueue<Runnable> taskQueue;
    private final HashSet<Worker> workers;

    private final ReentrantLock mainLock = new ReentrantLock();
    // private final Condition termination = mainLock.newCondition();

    public MyThreadPoolExecutor(int corePoolSize) {
        this.corePoolSize = corePoolSize;
        this.taskQueue = new LinkedBlockingQueue<>();
        this.workers = new HashSet<>();
    }

    private final class Worker implements Runnable {

        final Thread t;
        Runnable firstTask;

        Worker(Runnable firstTask) {
            this.firstTask = firstTask;
            t = new Thread(this);
        }

        @Override
        public void run() {
            runWorker(this);
        }
    }

    public void submit(Runnable task) {
        if (workers.size() < corePoolSize) {
            addWorker(task);
            return;
        }
        taskQueue.add(task);
    }

    private void addWorker(Runnable firstTask) {
        Worker worker = new Worker(firstTask);
        mainLock.lock();
        try {
            workers.add(worker);
        } finally {
            mainLock.unlock();
        }
        worker.run();
    }

    private void runWorker(Worker worker) {
        Runnable task = worker.firstTask;
        worker.firstTask = null;

        while (task != null || (getTask() != null)) {
            task.run();
            task = taskQueue.poll();
        }
    }

    private Runnable getTask() {
        try {
            return taskQueue.take();
        } catch (InterruptedException e) {
            return null;
        }
    }

}

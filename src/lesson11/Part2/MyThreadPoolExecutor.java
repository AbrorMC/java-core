package lesson11.Part2;

import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadPoolExecutor {

    private final int corePoolSize;
    private final BlockingQueue<Runnable> taskQueue;
    private final HashSet<Worker> workers;

    private final ReentrantLock mainLock = new ReentrantLock();
    private final Condition termination = mainLock.newCondition();
    private boolean isShutdown = false;

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

    public void shutdown() {
        mainLock.lock();
        try {
            isShutdown = true;
            if (workers.isEmpty()) {
                termination.signalAll();
            }
        } finally {
            mainLock.unlock();
        }
    }

    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        mainLock.lock();
        try {
            while (!isShutdown || !taskQueue.isEmpty() || !workers.isEmpty()) {
                if (nanos <= 0L)
                    return false;
                nanos = termination.awaitNanos(nanos);
            }
            return true;
        } finally {
            mainLock.unlock();
        }
    }

    private void addWorker(Runnable firstTask) {
        Worker worker = new Worker(firstTask);
        mainLock.lock();
        try {
            if (!isShutdown)
                workers.add(worker);
        } finally {
            mainLock.unlock();
        }
        worker.t.start();
    }

    private void runWorker(Worker worker) {
        Runnable task = worker.firstTask;
        worker.firstTask = null;

        try {
            while (task != null || (task = getTask()) != null) {
                task.run();
                if (!taskQueue.isEmpty())
                    task = taskQueue.poll();
                else
                    task = null;
            }
        } finally {
            deleteWorker(worker);
        }
    }

    private Runnable getTask() {
        try {
            if (isShutdown && taskQueue.isEmpty())
                return null;
            return taskQueue.take();
        } catch (InterruptedException e) {
            return null;
        }
    }

    private void deleteWorker(Worker worker) {
        mainLock.lock();
        try {
            workers.remove(worker);
            if (isShutdown && workers.isEmpty())
                termination.signalAll();
        } finally {
            mainLock.unlock();
        }
    }

}

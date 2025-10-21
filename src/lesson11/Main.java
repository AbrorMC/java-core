package lesson11;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Publisher publisher = new Publisher(queue);
        Subscriber subscriber = new Subscriber(queue);

        System.out.println("Введите слово или 'exit' для завершения.");

        executorService.execute(publisher);
        executorService.execute(subscriber);

        executorService.shutdown();
    }
}

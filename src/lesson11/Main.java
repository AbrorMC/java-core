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

        System.out.println("Система Publisher/Subscriber запущена. Вводите слова или 'exit' для завершения.");

        executorService.submit(publisher);
        executorService.submit(subscriber);

        executorService.shutdown();

        System.out.println("Программа завершена.");
    }
}

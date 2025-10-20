package lesson11;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

class Publisher implements Runnable {
    private final BlockingQueue<String> queue;
    private static final String EXIT_COMMAND = "exit";

    public Publisher(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(100);
                System.out.print("Publisher> Введите слово: ");
                String word = scanner.nextLine();

                queue.put(word);
                System.out.println("Publisher> Добавлено в очередь: " + word);

                if (word.equalsIgnoreCase(EXIT_COMMAND)) {
                    break;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
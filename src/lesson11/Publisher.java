package lesson11;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

class Publisher implements Runnable {
    private final BlockingQueue<String> queue;
    private static String EXIT = "exit";

    public Publisher(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (!Thread.currentThread().isInterrupted()) {
                String word = null;
                if (queue.isEmpty()) {
                    word = scanner.nextLine();
                    queue.put(word);
                }

                if (word.equalsIgnoreCase(EXIT))
                    break;

                if (word != null) {
                    System.out.println("Publisher -> Добавлено в очередь: " + word);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Publisher завершил свою работу.");
    }
}
package lesson11.Part1;

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
                String word = scanner.nextLine();

                if (!word.equalsIgnoreCase(EXIT))
                    System.out.println("Publisher -> Добавлено в очередь: " + word);

                queue.put(word);

                if (word.equalsIgnoreCase(EXIT))
                    break;

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Publisher завершил свою работу.");
    }
}


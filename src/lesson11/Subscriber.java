package lesson11;

import java.util.concurrent.BlockingQueue;

class Subscriber implements Runnable {
    private final BlockingQueue<String> queue;
    private static String EXIT = "exit";

    public Subscriber(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                String word = queue.take();

                if (word.equalsIgnoreCase(EXIT)) {
                    break;
                }

                System.out.println("Subscriber -> Извлечено из очереди: " + word);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Subscriber завершил свою работу.");
    }
}
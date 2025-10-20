package lesson11;

import java.util.concurrent.BlockingQueue;

class Subscriber implements Runnable {
    private final BlockingQueue<String> queue;
    private static final String EXIT_COMMAND = "exit";

    public Subscriber(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                String word = queue.take();
                System.out.println("Subscriber> Извлечено из очереди: " + word);

                if (word.equalsIgnoreCase(EXIT_COMMAND)) {
                    queue.put(word);
                    break;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
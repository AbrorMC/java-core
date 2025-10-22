package lesson11.Part2;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        MyThreadPoolExecutor executor = new MyThreadPoolExecutor(2);

        for (int i = 1; i <= 8; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName()
                        + " выполняет задачу " + taskId);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()
                            + " прерван при выполнении задачи " + taskId);
                }
                System.out.println(Thread.currentThread().getName()
                        + " завершил задачу " + taskId);
            });
        }

        executor.shutdown();

        try {
            if (executor.awaitTermination(50 * 10 ^ 9, TimeUnit.SECONDS)) {
                System.out.println("Все задачи завершены");
            } else {
                System.out.println("Истек таймаут ожидания");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Все задачи завершены. Завершаем программу.");
    }
}

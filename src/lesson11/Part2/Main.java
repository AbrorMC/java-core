package lesson11.Part2;

public class Main {
    public static void main(String[] args) {
        // Создаём пул с 2 основными потоками, максимум 4 и очередью на 10 задач
        MyThreadPoolExecutor executor = new MyThreadPoolExecutor(2);

        // Отправляем несколько задач на выполнение
        for (int i = 1; i <= 8; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName()
                        + " выполняет задачу " + taskId);
                try {
                    Thread.sleep(1); // имитация работы
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()
                            + " прерван при выполнении задачи " + taskId);
                }
                System.out.println(Thread.currentThread().getName()
                        + " завершил задачу " + taskId);
            });
        }

        // // Завершаем приём новых задач
        // executor.shutdown();

        // // Ожидаем завершения всех задач
        // try {
        // executor.awaitTermination();
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }

        System.out.println("Все задачи завершены. Завершаем программу.");
    }
}

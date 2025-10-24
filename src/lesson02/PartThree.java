package lesson02;

import java.util.Scanner;

public class PartThree {
    public static final Scanner scanner = new Scanner(System.in);

    public void startGame() {
        System.out.println("\nСцена 1: Пробуждение. Не доверяй голосам. Иди к северу.");

        System.out.println("1: Пойти на восток, туда, где в тумане мерцает свет.");
        System.out.println("2: Пойти на север, как советует записка.");
        System.out.println("3: Остаться у озера, может, кто-то придёт.");

        int choise = scanner.nextInt();

        switch (choise) {
            case 1 -> runScene2A();
            case 2 -> runScene2B();
            case 3 -> runScene2C();
        }
    }

    private void runScene2A() {
        System.out.println("\nСцена 2А: Восточный свет. Стоять. Идентификация...");

        System.out.println("1: Ответить: \"Я человек, я потерялся!\"");
        System.out.println("2: Убежать назад в лес.");

        int choise = scanner.nextInt();

        switch (choise) {
            case 1 -> runScene3A();
            case 2 -> runScene3B();
        }
    }

    private void runScene2B() {
        System.out.println(
                "\nСцена 2Б: Северный путь. Озеро просыпается в полнолуние. Не верь голосам. Прячься до рассвета.");

        System.out.println("1: Остаться в доме до рассвета.");
        System.out.println("2: Выйти и идти дальше в туман.");

        int choise = scanner.nextInt();

        switch (choise) {
            case 1 -> runScene3C();
            case 2 -> runScene3D();
        }
    }

    private void runScene2C() {
        System.out.println("\nСцена 2С: Ожидание у озера. \"Помоги мне... пожалуйста...\"");

        System.out.println("1: Пойти на голос.");
        System.out.println("2: Убежать прочь в лес.");

        int choise = scanner.nextInt();

        switch (choise) {
            case 1 -> runScene3E();
            case 2 -> runScene3F();
        }
    }

    private void runScene3A() {
        System.out.println("\nСцена 3A: Попытка общения.");

        System.out.println("Неудача - Исчезновение, смерть");
    }

    private void runScene3B() {
        System.out.println("\nСцена 3B: Побег.");

        System.out.println("Неудача - Исчезновение, смерть");
    }

    private void runScene3C() {
        System.out.println("\nСцена 3C: Ожидание.");

        System.out.println("Победа - Спасение, эвакуация");
    }

    private void runScene3D() {
        System.out.println("\nСцена 3D: Поиски.");

        System.out.println("Победа - Спасение, эвакуация");
    }

    private void runScene3E() {
        System.out.println("\nСцена 3E: Девочка.");

        System.out.println("Проклятие озера - Попал под влияние озера");
    }

    private void runScene3F() {
        System.out.println("\nСцена 3F: Побег в лес.");

        System.out.println("1: Разрушить центр управления.");
        System.out.println("2: Присоединиться к проекту.");

        int choise = scanner.nextInt();

        switch (choise) {
            case 1 -> runScene4A();
            case 2 -> runScene4B();
        }
    }

    private void runScene4A() {
        System.out.println("\nСцена 4A: Разрушение.");

        System.out.println("Герой - Спас мир, но погиб.");
    }

    private void runScene4B() {
        System.out.println("\nСцена 4B: Присоединение.");

        System.out.println("Тайный участник - Стал частью эксперимента.");
    }

}

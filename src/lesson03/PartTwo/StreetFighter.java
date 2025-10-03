package lesson03.PartTwo;

import java.util.Random;

public class StreetFighter {
    static final int minAttack = 6;
    static final int maxAttack = 10;
    static final int minHealth = 15;
    static final int maxHealth = 25;
    static final int fightersCount = 10;
    static final Random rand = new Random();

    public static void main(String[] args) {

        System.out.println("Player creation!\n");
        createFighters();
        printFighters();

        System.out.println("Game is started!\n");
        gameLoop();

        System.out.println("Game is finished!\n");
        printFighters();

        System.out.printf("The winner is %s!\n\n", getWinner().getName());

    }

    private static void createFighters() {
        for (int i = 1; i <= fightersCount; i++) {
            new Fighter(i, "Fighter №" + i, (int) (Math.random() * (maxHealth - minHealth + 1)) + minHealth,
                    (int) (Math.random() * (maxAttack - minAttack + 1)) + minAttack);
        }
    }

    private static void printFighters() {
        for (Fighter f : Fighter.getFighters().values()) {
            System.out.println(f.getFighterInfo());
        }
        System.out.println();
    }

    private static void gameLoop() {
        while (true) {
            long count = Fighter.getFighters().values()
                    .stream()
                    .filter(fighter -> fighter.getHealth() > 0)
                    .count();
            if (count == 1)
                break;

            int firstNumberOfFighter = rand.nextInt(fightersCount + 1);
            int secondNumberOfFighter = rand.nextInt(fightersCount + 1);
            if (firstNumberOfFighter != secondNumberOfFighter) {
                Fighter f1 = Fighter.getFighters().get(firstNumberOfFighter);
                Fighter f2 = Fighter.getFighters().get(secondNumberOfFighter);
                if (f1 != null) {
                    f1.fight(f2);
                }
            }
        }
    }

    private static Fighter getWinner() {
        return Fighter.getFighters().values()
                .stream()
                .filter(f -> f.getHealth() > 0)
                .findAny().get();
    }
}

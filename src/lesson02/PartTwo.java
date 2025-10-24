package lesson02;

import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class PartTwo {

    private static final Scanner scanner = new Scanner(System.in);

    public void runTasks() {

        System.out.println("\nTask number 1:\n");
        swapValues(getIntFromInput(), getIntFromInput());

        System.out.println("\nTask number 2:\n");
        printMultiplicationTable(getIntFromInput());

        System.out.println("\nTask number 3:\n");
        currencyConverter(getIntFromInput());

        System.out.println("\nTask number 4:\n");
        printOddOrEven(getIntFromInput());

        System.out.println("\nTask number 5:\n");
        printMax(getIntFromInput(), getIntFromInput(), getIntFromInput());

        System.out.println("\nTask number 6:\n");
        calculator(getDoubleFromInput(), getDoubleFromInput(), getCharFromInput());

        System.out.println("\nTask number 7:\n");
        printAverageValue(getIntFromInput());

        System.out.println("\nTask number 8:\n");
        searchValue(getIntFromInput(), getIntFromInput());

        System.out.println("\nTask number 9:\n");
        guessTheNumber();

    }

    private void swapValues(int firstValue, int secondValue) {
        System.out.println("First value" + secondValue + " second value " + firstValue);
    }

    private void printMultiplicationTable(int maxValue) {
        System.out.println("");
        int count = 1;
        int temp = (maxValue % 5 > 0) ? 1 : 0;
        int group = maxValue / 5 + temp;
        while (group > 0) {
            for (int i = 1; i <= 10; i++) {
                for (int j = (count - 1) * 5 + 1; j <= count * 5; j++) {
                    if (j > maxValue)
                        break;
                    System.out.print(j + " * " + i + " = " + i * j + "\t");
                }
                System.out.println("");
            }
            count++;
            group--;
            System.out.println("");
        }
    }

    private void currencyConverter(int amount) {
        int exchange = 12500;
        System.out.println(amount * exchange);
    }

    private void printOddOrEven(int number) {
        System.out
                .println((number % 2 == 0) ? "The number " + number + " is even" : "The number " + number + " is odd");
    }

    private void printMax(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        System.out.println("Max value: " + max);
    }

    private void calculator(double numberOne, double numberTwo, char operation) {
        double result = 0;
        switch (operation) {
            case '+' -> result = numberOne + numberTwo;
            case '-' -> result = numberOne - numberTwo;
            case '*' -> result = numberOne * numberTwo;
            case '/' -> {
                if (numberTwo != 0) {
                    result = numberOne / numberTwo;
                } else {
                    System.out.println("Error: division by zero!");
                    return;
                }
            }
        }
        System.out.println(result);
    }

    private void printAverageValue(int size) {
        int[] array = new int[size];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = getIntFromInput();
            sum += array[i];
        }
        System.out.println(sum / size);
    }

    private void searchValue(int size, int value) {
        boolean isContains = false;
        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = getIntFromInput();
        }
        for (int i = 0; i < array.length; i++) {
            isContains = array[i] == value;
            if (isContains)
                break;
        }

        System.out.println(isContains ? "The number " + value + " is in the array"
                : "The number " + value + " is not in the array");
    }

    private void guessTheNumber() {
        int genNumber = new Random().nextInt(100);
        // System.out.println(genNumber);
        int count = 5;
        int input;
        while (count > 0) {
            count--;
            input = getIntFromInput();
            if (genNumber == input) {
                System.out.println("You guess the number. Tou won!");
                return;
            }
        }
        System.out.println("You couldn't guess the number. You lose!");
    }

    private int getIntFromInput() {
        System.out.println("Please, enter number");
        int result;
        while (true) {
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                if (result < 1) {
                    System.out.println("Please, enter number greater than 0!");
                } else {
                    break;
                }
            } else {
                System.out.println("Please, enter valid number");
                scanner.next();
            }
        }
        return result;
    }

    private double getDoubleFromInput() {
        System.out.println("Please, enter number");
        double result;
        while (true) {
            if (scanner.hasNextDouble()) {
                result = scanner.nextDouble();
                if (result < 1) {
                    System.out.println("Please, enter number greater than 0!");
                } else {
                    break;
                }
            } else {
                System.out.println("Please, enter valid number");
                scanner.next();
            }
        }
        return result;
    }

    private char getCharFromInput() {
        System.out.println("Please, enter one of the symbols +,-,*,/");
        char result;
        while (true) {
            if (scanner.hasNext("[+\\-*/]")) {
                result = scanner.next().charAt(0);
                break;
            } else {
                System.out.println("Please, enter valid symbol");
                scanner.next();
            }
        }
        return result;
    }

}

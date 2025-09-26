package lesson02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task number 1:\n");
        numbersFromOneToHundred();

        System.out.println("Task number 2:\n");
        int number = getInput();
        sumOfNumbersFromOneToN(number);
    }

    public static int getInput() {
        System.out.println("Please, enter number");
        Scanner scanner = new Scanner(System.in);
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
                System.out.println("Please, enter number");
                scanner.next();
            }
        }
        scanner.close();
        return result;
    }
    public static void numbersFromOneToHundred() {
        int number = 1;
        while (number <= 100) {
            if (number > 1 && number % 10 == 1)
                System.out.print('\n');
            else
                System.out.print(number + " ");
            number++;
        }
        System.out.println("\n");
    }

    public static void sumOfNumbersFromOneToN(int lastNumber) {
        int result = 0, number = 0;
        while (number <= lastNumber) {
            result += number;
            number++;
        }
        System.out.println(result);
    }
}


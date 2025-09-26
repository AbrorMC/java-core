import java.util.Scanner;
import java.lang.Math;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Task number 1:\n");
        numbersFromOneToHundred();

        System.out.println("Task number 2:\n");
        sumOfNumbers(getInput());

        System.out.println("Task number 3 and 7:\n");
        factorial(getInput());

        System.out.println("Task number 4:\n");
        sumOfOddNumbers(getInput());

        System.out.println("Task number 5:\n");
        sumOfDigits(getInput());

        System.out.println("Task number 6:\n");
        turnNumber(getInput());

        System.out.println("Task number 8:\n");
        findDivisibleToSeven();

        System.out.println("Task number 9:\n");
        printPrimeNumbers(getInput());
    }

    public static int getInput() {
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
    
    public static void numbersFromOneToHundred() {
        int number = 1;
        while (number <= 100) {
            System.out.print(number);
            if (number % 10 == 0)
                System.out.print("\n");
            else
                System.out.print(" ");
            number++;
        }
        System.out.println("\n");
    }

    public static void sumOfNumbers(int number) {
        int result = 0, curNumber = 0;
        while (curNumber <= number) {
            result += curNumber;
            curNumber++;
        }
        System.out.println(result + "\n");
    }

    public static void factorial(int number) {
        int result = 1, curNumber = 1;
        while (curNumber <= number) {
            result *= curNumber;
            curNumber++;
        }
        System.out.println(result + "\n");
    }

    public static void sumOfOddNumbers(int number) {
        int result = 0, curNumber = 0;
        while (curNumber <= number) {
            if (curNumber % 2 == 0)
                result += curNumber;
            curNumber++;
        }
        System.out.println(result + "\n");
    }
    
    public static void sumOfDigits(int number) {
        int result = 0, digit = 0;
        while (number > 0) {
            digit = number % 10;
            number /= 10;
            result += digit;
        }
        System.out.println(result + "\n");
    }
    
    public static void turnNumber(int number) {
        int result = 0, digit = 0;
        while (number > 0) {
            digit = number % 10;
            number /= 10;
            result = result * 10 + digit;
        }
        System.out.println(result + "\n");
    }
    
    public static void findDivisibleToSeven() {
        int result = 0, digit = 0, number = 1000;
        while (true) {
            digit = number % 7;
            if (digit == 0) {
                result = number;
                break;
            }
            number++;
        }
        System.out.println(result + "\n");
    }
    
    public static void printPrimeNumbers(int number) {
        int curNumber = 2;
        while (curNumber < number) {
            if (isPrime(curNumber))
                System.out.print(curNumber + " ");
            curNumber++;
        }
        System.out.println("\n");
    }
    
    private static Boolean isPrime(int number) {
        for (int i = 2; i < Math.sqrt(number) + 1; i++) {
            if (number % i == 0 && number != 2)
                return false;
        }
        return true;
    }
}


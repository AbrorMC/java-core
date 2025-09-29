public class Part2 {
    public static void swapValues(int firstValue, int secondValue) {
        System.out.println("First value" + secondValue + " second value " + );
    }

    public static void printMultiplicationTable(int maxValue) {
        System.out.println("");
        int count = 1;
        int temp = (maxValue % 5 > 0) ? 1 : 0;
        int group = maxValue / 5 + temp;
        while (group > 0) {
            for (int i = 1; i <= 10; i++) {
                for (int j = (count - 1) * 5 + 1; j <= count * 5; j++) {
                    if (j > maxValue) break;
                    System.out.print(j + " * " + i + " = " + i * j + "\t");
                }
                System.out.println("");
            }
            count++;
            group--;
            System.out.println("");
        }
    }
}

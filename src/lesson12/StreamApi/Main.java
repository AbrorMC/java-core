package lesson12.StreamApi;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("###############");
        System.out.println("Task 1.");
        System.out.println("###############");
        System.out.println("Loop");

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                System.out.println(number * number);
            }
        }
        System.out.println("===============");

        System.out.println("StreamApi");
        numbers.stream()
                .filter(e -> e.intValue() % 2 == 0)
                .forEach(e -> System.out.println(e * e));
        System.out.println("===============");

        System.out.println("###############");
        System.out.println("Task 2.");
        System.out.println("###############");
        System.out.println("Loop");

        List<String> words = List.of("apple", "banana", "pear", "pineapple");
        int wordCount = 0;
        for (String word : words) {
            if (word.length() > 5) {
                wordCount++;
            }
        }
        System.out.println(wordCount);
        System.out.println("===============");

        System.out.println("StreamApi");
        long wordCountByStream = words.stream()
                .filter(e -> e.length() > 5)
                .count();
        System.out.println(wordCountByStream);
        System.out.println("===============");

        System.out.println("###############");
        System.out.println("Task 3.");
        System.out.println("###############");
        System.out.println("Loop");

        List<Integer> nums = List.of(10, 2, 33, 4, 25);
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (Integer num : nums) {
            if (num > max)
                max = num;

            if (num < min)
                min = num;
        }
        System.out.printf("Min value: %d, max value: %d\n", min, max);
        System.out.println("===============");

        System.out.println("StreamApi");
        Optional<Integer> maxValue = nums.stream().max(Integer::compare);
        Optional<Integer> minValue = nums.stream().min(Integer::compare);
        System.out.printf("Min value: %d, max value: %d\n", minValue.get(), maxValue.get());
        System.out.println("===============");

        System.out.println("###############");
        System.out.println("Task 4.");
        System.out.println("###############");
        System.out.println("Loop");

        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
        int namesLength = 0;
        for (String name : names) {
            namesLength += name.length();
        }
        System.out.println(namesLength / names.size());
        System.out.println("===============");

        System.out.println("StreamApi");
        int averageLength = (int) names.stream().mapToInt(String::length).average().getAsDouble();
        System.out.println(averageLength);
        System.out.println("===============");

        System.out.println("###############");
        System.out.println("Task 5.");
        System.out.println("###############");
        System.out.println("Loop");

        List<String> input = List.of("apple", "pear", "apple", "banana", "pear");
        List<String> inputList = new ArrayList<>();
        for (String string : input) {
            if (!inputList.contains(string))
                inputList.add(string);
        }

        inputList.sort(Comparator.comparingInt(String::length));

        System.out.println(inputList);
        System.out.println("===============");

        System.out.println("StreamApi");
        List<String> inputStreamList = input.stream()
                .distinct()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        System.out.println(inputStreamList);
        System.out.println("===============");

        System.out.println("###############");
        System.out.println("Task 6.");
        System.out.println("###############");
        System.out.println("Loop");

        List<String> fruits = List.of("apple", "banana", "kiwi");
        Map<String, Integer> map = new HashMap<>();
        for (String string : fruits) {
            map.put(string, string.length());
        }
        System.out.println(map);
        System.out.println("===============");

        System.out.println("StreamApi");
        Map<String, Integer> mapStream = fruits.stream().collect(Collectors.toMap(f -> f, String::length));
        System.out.println(mapStream);
        System.out.println("===============");

        System.out.println("###############");
        System.out.println("Task 7.");
        System.out.println("###############");
        System.out.println("Loop");

        List<String> namesList = List.of("Alice", "Andrew", "Bob", "Charlie", "Catherine");
        HashMap<String, List<String>> namesMap = new HashMap<>();
        for (String name : namesList) {
            String firstLetter = name.substring(0, 1);
            if (!namesMap.containsKey(firstLetter)) {
                namesMap.put(firstLetter, new ArrayList<>());
            }
            namesMap.get(firstLetter).add(name);
        }
        System.out.println(namesMap);
        System.out.println("===============");

        System.out.println("StreamApi");
        Map<String, List<String>> namesStreamMap = namesList.stream()
                .collect(Collectors.groupingBy(e -> e.substring(0, 1)));
        System.out.println(namesStreamMap);
        System.out.println("===============");

        System.out.println("###############");
        System.out.println("Task 8.");
        System.out.println("###############");
        System.out.println("Loop");

        List<String> namesList2 = List.of("Tom", "Jerry", "Spike");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < namesList2.size(); i++) {
            result.append(namesList2.get(i));
            if (i != namesList2.size() - 1)
                result.append(", ");
        }
        System.out.println(result);
        System.out.println("===============");

        System.out.println("StreamApi");
        String split = namesList2.stream().reduce((x, y) -> x + ", " + y).get();
        System.out.println(split);
        System.out.println("===============");

        System.out.println("###############");
        System.out.println("Task 9.");
        System.out.println("###############");
        System.out.println("Loop");

        List<String> sentences = List.of("Java is cool", "Streams are powerful");
        List<String> wordsList = new ArrayList<>();
        for (String sentence : sentences) {
            String[] wordsArray = sentence.split(" ");
            wordsList.addAll(Arrays.asList(wordsArray));
        }
        System.out.println(wordsList);
        System.out.println("===============");

        System.out.println("StreamApi");
        List<String> temp = sentences.stream()
                .reduce((x,y) -> x + " " + y)
                .map(s -> s.split(" "))
                .map(Arrays::asList)
                .get();
        System.out.println(temp);
        System.out.println("===============");

        System.out.println("###############");
        System.out.println("Task 10.");
        System.out.println("###############");
        System.out.println("Loop");

        record Product(String name, String category, double price) {}
        List<Product> products = List.of(
                new Product("Phone", "Electronics", 1200),
                new Product("TV", "Electronics", 1800),
                new Product("Apple", "Fruits", 2.5),
                new Product("Mango", "Fruits", 4.0));
        Map<String, Product> productMap = new HashMap<>();

        for (Product product : products) {
            if (!productMap.containsKey(product.category)) {
                productMap.put(product.category, product);
            } else if (product.price > productMap.get(product.category).price){
                productMap.put(product.category, product);
            }
        }
        System.out.println(productMap);
        System.out.println("===============");

        System.out.println("StreamApi");
        Map<String, Product> productMapStream = products.stream()
                .collect(Collectors.toMap(
                        Product::category,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparingDouble(Product::price))
                ));
        System.out.println(productMapStream);
        System.out.println("===============");
    }
}

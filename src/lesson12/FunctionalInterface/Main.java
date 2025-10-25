package lesson12.FunctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("###############");
        System.out.println("Task 1.");
        Predicate<String> checkString = s -> s != null && s.length() > 3;
        System.out.println(checkString.test("StreamApi"));
        System.out.println("###############");

        System.out.println("###############");
        System.out.println("Task 2.");
        Function<String, Integer> stringLength = String::length;
        System.out.println(stringLength.apply("StreamApi"));
        System.out.println("###############");

        System.out.println("###############");
        System.out.println("Task 3.");
        Supplier<UUID> getUUID = UUID::randomUUID;
        System.out.println(getUUID.get());
        System.out.println("###############");

        System.out.println("###############");
        System.out.println("Task 4.");
        Consumer<String> getUpperCase = s -> System.out.println(s.toUpperCase());
        getUpperCase.accept("StreamApi");
        System.out.println("###############");

        System.out.println("###############");
        System.out.println("Task 5.");
        BiFunction<Integer, Integer, Integer> sum = Integer::sum;
        System.out.println(sum.apply(5, 15));
        System.out.println("###############");

        System.out.println("###############");
        System.out.println("Task 6.");
        Function<String, String> trim = String::trim;
        Function<String, String> toUpperCase = String::toUpperCase;
        Function<String, String> trimThenToUpperCase = trim.andThen(toUpperCase);
        System.out.println(trimThenToUpperCase.apply("  Stream Api   "));
        System.out.println("###############");

        System.out.println("###############");
        System.out.println("Task 7.");
        Consumer<String> printWord = System.out::println;
        Consumer<String> printLength = s -> System.out.println(s.length());
        Consumer<String> printWordAndLength = printWord.andThen(printLength);
        printWordAndLength.accept("StreamApi");
        System.out.println("###############");

        System.out.println("###############");
        System.out.println("Task 8.");
        Predicate<Integer> isEven = i -> i % 2 == 0;
        Predicate<Integer> isPositive = i -> i > 0;
        Predicate<Integer> isEvenOrPositive = isEven.or(isPositive);
        System.out.println(isEvenOrPositive.test(-5));
        System.out.println(isEvenOrPositive.test(5));
        System.out.println(isEvenOrPositive.test(-2));
        System.out.println("###############");

        System.out.println("###############");
        System.out.println("Task 9.");
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        Function<Integer, String> toStr = x -> "Result: " + x;
        BiFunction<Integer, Integer, String> multiplyToStr = multiply.andThen(toStr);
        System.out.println(multiplyToStr.apply(5,6));
        System.out.println("###############");

        System.out.println("###############");
        System.out.println("Task 10.");
        UnaryOperator<String> addChars = s -> s + "!!!";
        System.out.println(addChars.apply("StreamApi"));
        System.out.println("###############");

        System.out.println("###############");
        System.out.println("Task 11.");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = filter(numbers, n -> n % 2 == 0);
        System.out.println(evenNumbers);
        System.out.println("###############");

        System.out.println("###############");
        System.out.println("Task 12.");
        List<String> strings = List.of("StreamApi", "Functional", "Interface");
        Function<String, Integer> mapper = String::length;
        List<Integer> strLength = map(strings, mapper);
        System.out.println(strLength);
        System.out.println("###############");

        System.out.println("###############");
        System.out.println("Task 13.");
        Consumer<String> consumer = System.out::println;
        forEach(strings, consumer);
        System.out.println("###############");

        System.out.println("###############");
        System.out.println("Task 14.");
        List<UUID> uuidList = generate(getUUID, 10);
        System.out.println(uuidList);
        System.out.println("###############");
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item: list) {
            if (predicate.test(item))
                result.add(item);
        }
        return result;
    }

    public static List<Integer> map(List<String> list, Function<String, Integer> mapper) {
        List<Integer> result = new ArrayList<>();
        for (String str : list) {
            result.add(mapper.apply(str));
        }
        return result;
    }

    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T item: list) {
            consumer.accept(item);
        }
    }

    public static <T> List<T> generate(Supplier<T> supplier, int n) {
        List<T> result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            result.add(i, supplier.get());
        }
        return result;
    }
}

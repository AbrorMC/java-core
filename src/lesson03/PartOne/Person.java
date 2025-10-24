package lesson03.PartOne;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.printf("Name - %s, age - %d years old.", name, age);
    }
}

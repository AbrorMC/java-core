package lesson05.Part1;

public abstract class Person {
    private final String id;
    private final String name;
    private final String surname;
    private final String email;

    public Person(String id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public abstract void printInfo();
}

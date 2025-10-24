package lesson05.Part1;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private final List<Course> courses;
    public Student(String id, String name, String surname, String email) {
        super(id, name, surname, email);
        this.courses = new ArrayList<>();
    }
    public List<Course> getCourses() {
        return courses;
    }
    public void printCoursesInfo() {
        for (Course course : getCourses()) {
            System.out.println(course);
        }
    }
    @Override
    public void printInfo() {
        System.out.println(this.getClass().getName() + " - " + super.getName() + " " + super.getSurname()
                + ", e-mail: " + super.getEmail());
    }
}

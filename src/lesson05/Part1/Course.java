package lesson05.Part1;

import java.util.Map;
import java.util.TreeMap;

public class Course {
    private final String id;
    private final String name;
    private final Teacher teacher;
    private final Map<String, Student> students = new TreeMap<>();

    public Course(String id, String name, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        if (student != null)
            students.put(student.getId(), student);
    }

    @Override
    public String toString() {
        return "id - " + id + ", name - " + name + ", teacher - " + teacher.getName() + " " + teacher.getSurname();
    }
}

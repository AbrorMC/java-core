package lesson05.Part1;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class Teacher extends Person {
    private final Map<String, Course> courses = new TreeMap<>();

    public Teacher(String id, String name, String surname, String email) {
        super(id, name, surname, email);
    }

    public Map<String, Course> getCourses() {
        return courses;
    }

    public void printCoursesInfo() {
        for (Course course : courses.values()) {
            System.out.println("id - " + course.getId() + ", name - " + course.getName());
        }
    }

    public Course createCourse(String id, String name) {
        Course course = new Course(id, name, this);
        courses.put(course.getId(), course);
        return course;
    }

    public void addStudent(Course course, Student student) {
        course.addStudent(student);
    }

    public void markAttendance(Course course, Student student, LocalDate date, boolean present) {
        AttendanceRegister.recordAttendance(course, student, date, present);
    }

    public void assignGrade(Course course, Student student, LocalDate date, int score) {
        GradeBook.assignGrade(course, student, date, score);
    }

    @Override
    public void printInfo() {
        System.out.println(this.getClass().getName() + " - " + super.getName() + " " + super.getSurname()
                            + ", e-mail: " + super.getEmail());
    }
}

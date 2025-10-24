package lesson05.Part1;

import java.time.LocalDate;

public class Attendance {
    private final Course course;
    private final Student student;
    private final LocalDate date;
    private Boolean present;

    public Attendance(Course course, Student student, LocalDate date, Boolean present) {
        this.course = course;
        this.student = student;
        this.date = date;
        this.present = present;
    }

    public Student getStudent() {
        return student;
    }

    public LocalDate getDate() {
        return date;
    }

    public Boolean isPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
    }

    @Override
    public String toString() {
        return course.getName() +
                ", student : " + student.getName() + " " + student.getSurname() +
                ", date : " + date +
                ", present : " + present;
    }
}

package lesson05.Part1;

import java.time.LocalDate;

public class Grade {
    private final Course course;
    private final Student student;
    private final LocalDate date;
    private int score;

    public Grade(Course course, Student student, LocalDate date, int score) {
        this.course = course;
        this.student = student;
        this.date = date;
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

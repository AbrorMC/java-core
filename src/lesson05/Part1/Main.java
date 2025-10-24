package lesson05.Part1;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("t1", "Ivanov", "Ivan", "i.ivanov@mail.ru");

        Course course1 = teacher1.createCourse("c1","Java Core");

        Student student1 = new Student("s1", "Petrov", "Petr", "p.petrov@mail.ru");
        Student student2 = new Student("s2", "Orlova", "Svetlana", "p.petrov@mail.ru");
        Student student3 = new Student("s3", "Petrova", "Anna", "p.petrov@mail.ru");

        teacher1.addStudent(course1, student1);
        teacher1.addStudent(course1, student2);
        teacher1.addStudent(course1, student3);

        teacher1.markAttendance(course1, student1, LocalDate.of(2025,10, 5), true);
        teacher1.markAttendance(course1, student2, LocalDate.of(2025,10, 5), false);
        teacher1.markAttendance(course1, student3, LocalDate.of(2025,10, 5), true);

        teacher1.assignGrade(course1, student1, LocalDate.of(2025,10, 5), 5);
        teacher1.assignGrade(course1, student3, LocalDate.of(2025,10, 5), 4);

        for (Attendance attendance : AttendanceRegister.getAttendances()) {
            System.out.println(attendance);
        }

        GradeBook.printTotalGrades();
    }
}


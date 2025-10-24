package lesson05.Part1;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GradeBook {
    private static final Map<String, Grade> grades = new TreeMap<>();

    public static List<Grade> getGrades() {
        return grades.values().stream().toList();
    }
    public static void assignGrade(Course course, Student student, LocalDate date, int score) {
        if (student != null)
            grades.put(student.getId(), new Grade(course, student, date, score));
    }

    public static void printTotalGrades() {
        Map<Student, Integer> totalGrades = grades.values().stream()
                .collect(Collectors.groupingBy(Grade::getStudent, Collectors.summingInt(Grade::getScore)));

        for (Map.Entry<Student, Integer> item : totalGrades.entrySet()) {
            System.out.println("Student : " + item.getKey().getName() + " " + item.getKey().getSurname() +
                    " grade : " + item.getValue());
        }
    }

}

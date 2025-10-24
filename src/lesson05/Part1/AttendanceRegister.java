package lesson05.Part1;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AttendanceRegister {
    private static final Map<String, Attendance> attendances = new TreeMap<>();

    public static List<Attendance> getAttendances() {
        return attendances.values().stream().toList();
    }

    public static void recordAttendance(Course course, Student student, LocalDate date, boolean present) {
        if (student != null)
            attendances.put(student.getId(), new Attendance(course, student, date, present));
    }

}

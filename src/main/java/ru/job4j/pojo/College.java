package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Jonny Mary Polly");
        student.setGroup("java-2021");
        student.setEnrollmentDate(LocalDate.of(2021, 8, 12));
        System.out.printf("""
                        Student {
                            "name" : "%s",
                            "group" : "%s",
                            "enrollment_date" : "%s"
                        }
                        """, student.getName(), student.getGroup(),
                student.getEnrollmentDate().format(DateTimeFormatter.ofPattern("dd.M.yy")));
    }
}

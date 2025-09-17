package riwi.week2.student;

import riwi.week2.student.model.Course;
import riwi.week2.student.model.Student;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("bany",18);
        student.addCourse(new Course("English", 30));
        System.out.println(student);
    }
}

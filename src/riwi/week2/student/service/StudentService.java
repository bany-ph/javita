package riwi.week2.student.service;

import riwi.week2.student.model.Student;
import riwi.week2.student.utils.FindElements;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private static List<Student> students = new ArrayList<>();

    public StudentService(){}

    public void addStudent(String name,int age){
        students.add(new Student(name,age));
    }

    public Student findStudentByName(String name){
        return FindElements.findByName(students,name,Student::getName);
    }
}

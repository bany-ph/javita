package riwi.week2.student.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Student extends Person{
    private List<Course> courses;

    public Student(String name, int age) {
        super(name, age);
        courses = new ArrayList<>(4);
    }


     public void addCourse(Course course){
            courses.add(course);
     }

    @Override
    public String toString() {
        return super.toString() + "\nAsignatures → [" + courses.stream().map(Course::getCourseName).collect(Collectors.joining(", ")) + "]";
    }

}

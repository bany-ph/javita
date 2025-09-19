package riwi.week2.student.model;

import java.util.ArrayList;
import java.util.List;

public class Enrollment {
    private Student student;
    private Course course;
    private List<Double> grades = new ArrayList<>();

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void addGrade(double grade){
        if(grades.size() >= 4){
            throw new IllegalStateException("Maximum 4 grades allowed");
        }
        grades.add(grade);
    }

    public List<Double> getGrades(){
        return grades;
    }
}

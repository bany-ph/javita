package riwi.week2.student.service;
import riwi.week2.student.model.Course;
import riwi.week2.student.model.Enrollment;
import riwi.week2.student.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;



public class EnrollmentService {
    private static List<Enrollment> enrollments = new ArrayList<>();
    private StudentService studentService = new StudentService();
    private CourseService courseService = new CourseService();


    public void enrollStudent(String studentName, String courseName){

        Student student = studentService.findStudentByName(studentName);
        Course course  = courseService.findCourseByName(courseName);

        if(student == null){
            throw new NoSuchElementException("The student was not found");
        }else if(course == null){
            throw new NoSuchElementException("The Course was not found");
        }

        enrollments.add(new Enrollment(student,course));
    }

    public void addGradeToStudent(double newGrade, String studentName, String courseName){
        Student student = studentService.findStudentByName(studentName);
        Course course  = courseService.findCourseByName(courseName);
        if(newGrade < 0){
            throw new IllegalArgumentException("No negative numbers allowed");
        }

        if(student == null){
            throw new NoSuchElementException("The student was not found");
        }
        if(course == null){
            throw new NoSuchElementException("The Course was not found");
        }

        Enrollment enrollment = findEnrollment(student,course);
        if(enrollment == null){
            throw new NoSuchElementException("No Enrollment found");
        }

        enrollments.get(enrollments.indexOf(enrollment)).addGrade(newGrade);
    }

    private Enrollment findEnrollment(Student student, Course course){
        return enrollments.stream()
                .filter(enrollment -> enrollment.getStudent() == student && enrollment.getCourse() == course)
                .findFirst()
                .orElse(null);
    }

    public List<Enrollment> getEnrollmentsByCourse(String courseName){
        Course course =  courseService.findCourseByName(courseName);
        return enrollments.stream()
                .filter(enrollment -> enrollment.getCourse() == course)
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudent(String studentName){
        Student student = studentService.findStudentByName(studentName);
        return enrollments.stream()
                .filter(enrollment -> enrollment.getStudent() == student)
                .map(Enrollment::getCourse)
                .collect(Collectors.toList());

    }
}

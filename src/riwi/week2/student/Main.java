package riwi.week2.student;

import riwi.week2.student.model.Student;
import riwi.week2.student.service.CourseService;
import riwi.week2.student.service.EnrollmentService;
import riwi.week2.student.service.ProfessorService;
import riwi.week2.student.service.StudentService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        ProfessorService professorService = new ProfessorService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        // add people ↓
        studentService.addStudent("Bany", 18);
        studentService.addStudent("Alfredo", 27);
        professorService.addNewProfessor("Carlos", 41 );
        professorService.addNewProfessor("Melisa", 35 );

        // add courses ↓
        courseService.addNewCourse("English","Carlos");
        courseService.addNewCourse("Math","Melisa");

        //enroll ↓
        enrollmentService.enrollStudent("Bany","English");
        enrollmentService.enrollStudent("Alfredo", "Math");


        //get students by course
        List<Student> studentsEnglish = enrollmentService.getStudentsByCourse("English");
        studentsEnglish.forEach(student -> System.out.println(student.getInformation()));
    }
}

package riwi.week2.student;

import riwi.week2.student.model.Enrollment;
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
        List<Enrollment> studentsEnglish = enrollmentService.getEnrollmentsByCourse("English");

        //add grade
        enrollmentService.addGradeToStudent(50,"Bany","English");
        enrollmentService.addGradeToStudent(70,"Bany","English");

        studentsEnglish.forEach(enrollment -> System.out.printf("""
                Student name: %s
                Grades: %s
                """,enrollment.getStudent().getName(),String.join(",", String.valueOf(enrollment.getGrades()))));


    }
}

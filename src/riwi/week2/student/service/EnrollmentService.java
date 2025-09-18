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

    public EnrollmentService(){}

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

    public List<Student> getStudentsByCourse(String courseName){
        Course course =  courseService.findCourseByName(courseName);
        return enrollments.stream()
                .filter(enrollment -> enrollment.getCourse() == course)
                .map(Enrollment::getStudent)
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByStudent(Student student){
        return null;
    }
}

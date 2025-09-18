package riwi.week2.student.service;

import riwi.week2.student.model.Course;
import riwi.week2.student.model.Professor;
import riwi.week2.student.utils.FindElements;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CourseService {
    private static List<Course> courses = new ArrayList<>();
    private static ProfessorService professorService = new ProfessorService();

    public CourseService(){

    }

    public void addNewCourse(String courseName, String profesorName){
       Professor professor = professorService.findProfessorByName(profesorName);
       Course course = findCourseByName(courseName);

       if( course != null ){
           throw new IllegalArgumentException("The course already exist");
       }

       if(professor == null ){

           throw new NoSuchElementException("The Professor was not found");
       }

       courses.add(new Course(courseName,professor));
    }

    public void deleteCourse(String courseName){}

    public Course findCourseByName(String name){
        return FindElements.findByName(courses,name, Course::getCourseName);
    }


}

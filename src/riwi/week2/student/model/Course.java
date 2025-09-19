package riwi.week2.student.model;



public class Course {
    private String courseName;
    private Professor professor;

    public Course(String courseName, Professor professor) {
        this.courseName = courseName;
        this.professor = professor;

    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Course{" +
                ", courseName='" + courseName + '\'' +
                ", professor=" + professor +
                '}';
    }
}

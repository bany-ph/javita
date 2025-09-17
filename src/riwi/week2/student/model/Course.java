package riwi.week2.student.model;

public class Course {
     
    private String courseName;
    private int grade;

    public Course(String courseName, int grade) {
        this.courseName = courseName;
        this.grade = grade;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if(grade < 0){
            throw new IllegalArgumentException();
        }
        this.grade = grade;
    }

    public String status(){
        return getGrade() > 3.5 ? "APROBADO" : "REPROBADO";
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", grade=" + grade +
                '}';
    }
}

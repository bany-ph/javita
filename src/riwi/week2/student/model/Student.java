package riwi.week2.student.model;


public class Student extends Person{

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public String getInformation() {
        return "\nID:" + getId()+ "\nName: " + getName() + "\nAge: " + getAge();
    }


}

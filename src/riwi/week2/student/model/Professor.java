package riwi.week2.student.model;

public class Professor extends Person {

    public Professor(String name, int age) {
        super(name, age);
    }

    @Override
    public String getInformation() {
        return "PROFESSOR ↓ \nName: " + getName() + "\nAge: " + getAge();
    }

}

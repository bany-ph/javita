package riwi.week2.student.service;

import riwi.week2.student.model.Professor;
import riwi.week2.student.utils.FindElements;

import java.util.ArrayList;
import java.util.List;

public class ProfessorService {
    private static List<Professor> professors = new ArrayList<>();

    public ProfessorService(){}

    public void addNewProfessor(String professorName, int age ){
          professors.add(new Professor(professorName,age));
    }
    public void deleteProfessor(String professorName){}

    public List<Professor> getAllProfessor(){
        return  professors;
    }

    public Professor findProfessorByName(String name){

        return FindElements.findByName(professors,name, Professor::getName);
    }
}

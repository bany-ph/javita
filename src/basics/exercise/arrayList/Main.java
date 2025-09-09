package basics.exercise.arrayList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
       ArrayList<String> names = new ArrayList<>();
        names.add("Menelik");
        names.add("Alfonso");
        names.add("Diego");
        names.add("Marta");

        // iterate
        for(String name : names){
            System.out.println("Hola, " + name);
        }

    }
}

package basics.exercise.hashMap;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer,String> people = new HashMap<>();
        people.put(1020202,"Brisbany");
        people.put(303030,"Mauricio");
        people.put(302020,"Alfredo");

        // iterate
        for (Map.Entry<Integer, String> entry : people.entrySet()){
            // string.format
            System.out.printf("Document: %d || Name: %s \n", entry.getKey(), entry.getValue());
        }

    }
}

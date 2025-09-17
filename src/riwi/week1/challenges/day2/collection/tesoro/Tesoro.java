package riwi.week1.challenges.day2.collection.tesoro;

import java.util.HashMap;

public class Tesoro {
    HashMap<String,Integer> tesoros;

    public Tesoro(){
        tesoros = new HashMap<>();
        // initial values
        tesoros.put("diamantes", 5);
        tesoros.put("plata", 50);
        tesoros.put("oro", 100);
    }

    public int getValueOf(String key){
        return tesoros.get(key.toLowerCase());
    }

    public void updateValue(String key,int newValue){
        tesoros.replace(key,newValue);
    }




}

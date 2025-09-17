package riwi.week1.challenges.day2.collection.cofre;

import java.util.Arrays;

public class Cofre {
    int[] items = {3,4,5,6,7};

    public Cofre(){}

    public int getLastItem(){
        return items[items.length - 1];
    }

    public int getFirstItem(){
        return items[0];
    }

    public void changeValueItem(int newItem, int replacement){
       items[(Arrays.asList(items).indexOf(replacement)) + 1] = newItem;
    }

    public String getItems(){
        return Arrays.toString(items);
    }

}

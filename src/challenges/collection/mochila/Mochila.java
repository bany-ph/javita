package challenges.collection.mochila;

import java.util.ArrayList;

public class Mochila {
    private ArrayList<String> mochila;

    public Mochila(){
        mochila = new ArrayList<>();
    }

    public void addItem(String newItem){
        mochila.add(newItem);
    }

    public void deleteItem(String item){
        mochila.remove(item);
    }

    public String getOneItem(int index){
        return mochila.get(index);
    }

    public ArrayList<String> getAllItems (){
        return mochila;
    }
}

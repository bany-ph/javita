package week1.challenges.day2.collection.mochila;

public class Main {
    public static void main(String[] args) {
        Mochila mochila = new Mochila();

        mochila.addItem("Papitas");
        mochila.addItem("Agua");
        mochila.addItem("Tamal");
        mochila.getOneItem(2);
        mochila.getAllItems();

    }
}

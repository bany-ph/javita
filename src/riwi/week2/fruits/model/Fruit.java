package riwi.week2.fruits.model;

import riwi.week2.fruits.Exception.UserDataInvalidException;

public class Fruit {
    private static int nextId = 1;
    private final int id;
    private String name;
    private double price;
    private double weight;
    private String color;

    public Fruit( String name,String color, double weight, double price) {
        this.id = nextId++;
        this.color = color;
        this.weight = weight;
        this.price = price;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) throw new UserDataInvalidException("The name of the fruit cannot be empty");
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0) throw new UserDataInvalidException("Price cannot be lower than 0");
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if(weight < 0) throw new UserDataInvalidException("Weight cannot be lower than 0");
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if(color.trim().isEmpty())throw new UserDataInvalidException("Color cannot be empty");
        this.color = color;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}

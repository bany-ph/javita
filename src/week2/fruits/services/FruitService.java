package week2.fruits.services;

import week2.fruits.model.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FruitService {
    List<Fruit> fruits = new ArrayList<>();

    public void createNewFruit(String name,String color, double price, double weight){
        fruits.add(new Fruit(name,color,weight,price));
    }
    public void deleteFruit(int id){
        Optional<Fruit> foundFruit = fruits.stream().filter(fruit ->  fruit.getId() == id).findFirst();
        foundFruit.ifPresent(fruit -> fruits.remove(fruit));
    }


    public Fruit searchFruitById(int id){
        return (Fruit) fruits.stream().filter(fruit -> fruit.getId() == id);
    }

    public StringBuilder listOfFruits(){
        StringBuilder res = new StringBuilder();
        fruits.forEach(fruit ->{
           res.append(String.format("%-5d %15s %5s %5f %5f\n", fruit.getId(),fruit.getName(),fruit.getColor(), fruit.getPrice(), fruit.getWeight()));
        });

        return res;
    }



}

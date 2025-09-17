package riwi.week2.fruits;

import riwi.week2.fruits.services.FruitService;

import javax.swing.*;

public class Main {
    static FruitService service = new FruitService();
    public static void main(String[] args) {

        boolean running = true;
        while(running){
            try {
                String[] options = {
                        "1. Add Fruit",
                        "2. List fruits",
                        "3. Search fruit",
                        "4. Update fruit",
                        "5. Delete fruit by id",
                        "6. Exit",
                };

                String choice = (String) JOptionPane.showInputDialog(
                        null,
                        "\nSeleccione una opción:",
                        "MENU",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]
                );

                if (choice == null) break;

                switch (choice) {
                    case "1. Add Fruit" -> {
                        createFruitView();
                    }
                    case "2. List fruits" -> {
                        listFruitsView();
                    }
                    case "3. Search fruit" -> {

                    }
                    case "4. Update fruit" -> {

                    }
                    case "5. Delete fruit by id" -> {

                    }
                    case "6. Exit" -> {
                        running = false;
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        null,
                        e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }


    static void  createFruitView(){
        try{
            String fruitNameStr = JOptionPane.showInputDialog(
                    null,
                    "Insert the name of the fruit",
                    "Create fruit",
                    JOptionPane.QUESTION_MESSAGE
            );

            String colorStr = JOptionPane.showInputDialog(
                    null,
                    "Insert the color of the fruit",
                    "Create fruit",
                    JOptionPane.QUESTION_MESSAGE
            );


            String weightStr = JOptionPane.showInputDialog(
                    null,
                    "Insert the weight",
                    "Create fruit",
                    JOptionPane.QUESTION_MESSAGE
            );

            String priceStr = JOptionPane.showInputDialog(
                    null,
                    "Insert the price of the fruit",
                    "Create fruit",
                    JOptionPane.QUESTION_MESSAGE
            );

            double weight = Double.parseDouble(weightStr);
            double price = Double.parseDouble(priceStr);

            service.createNewFruit(fruitNameStr,colorStr,price,weight);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

    }

    static void listFruitsView(){
        JOptionPane.showMessageDialog(
                null,
                service.listOfFruits(),
                "Lista de Productos",
                JOptionPane.INFORMATION_MESSAGE
        );
    }



}

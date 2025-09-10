package challenges.day2.loop.exercise4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cuantity = sc.nextInt();
        String[] regex = {"^-\\\\d+$", "^0$" ,"^-\\\\d+$" }; //{negative,zero,positive}
        String numbersString = "";
        for (int i = 0; i < cuantity ; i++) {
            int number = sc.nextInt();
            numbersString += String.valueOf(number) + " ";
        }
        System.out.println(numbersString);
        System.out.println("Negative numbers: " + (numbersString.matches(regex[0]) ? numbersString : "No numbers found"));
        System.out.println("Numbers equal to zero : " + (numbersString.matches(regex[1]) ? numbersString : "No numbers found"));
        System.out.println("Positive numbers: " + (numbersString.matches(regex[2]) ? numbersString : "No numbers found"));


    }
}

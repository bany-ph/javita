package week1.challenges.day3.review;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DoWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean end = false;
        int input;
        int  randomNumber = (int)(Math.random() * (100 - 1 + 1) - 1);
        do{
            try{
                input = sc.nextInt();
                if(Math.abs((input - randomNumber)) <= 5 && input != randomNumber){
                    System.out.println("You're so close!: " + randomNumber);
                }else if(input > randomNumber){
                    System.out.println("The number is smaller");
                } else if (input < randomNumber) {
                    System.out.println("The number is greater");
                }else{
                    System.out.println("You win! \n -> " + randomNumber);
                    end = true;
                }
            }catch (InputMismatchException e){
                System.out.println("Enter a number !");
                sc.next();
            }
        }while (!end);

    }
}

package riwi.week1.challenges.day3.review;

import java.util.Scanner;

public class While {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int normalNumber = sc.nextInt();
        String reverseNumber = "";
        int i = String.valueOf(normalNumber).length() - 1;

        while(i >= 0){
            reverseNumber += String.valueOf(normalNumber).charAt(i);
            i--;
        }

        System.out.println("Reverse Number:" + reverseNumber + "\n");
        System.out.println(reverseNumber.equals(String.valueOf(normalNumber)) ? "IT'S CAPICUA" : "IT'S NOT CAPICUA");
    }
}

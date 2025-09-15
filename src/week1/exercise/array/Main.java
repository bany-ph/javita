package week1.exercise.array;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = {5, 8, 10 ,4 , 12};

        for (int num : numbers){
            System.out.println(num * 2);
        }

        // user enter the numbers
        int[] userNumbers = new int[6];
        for (int i = 0; i < userNumbers.length; i++) {
            userNumbers[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(userNumbers)); // show week1.exercise.array


    }
}

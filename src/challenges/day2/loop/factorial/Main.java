package challenges.day2.loop.factorial;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*  */
        int number = sc.nextInt();
        int result = 1;

        for (int i = number; i > 0 ; i--) {
            result *= i;
        }
        System.out.println(result);
    }






}

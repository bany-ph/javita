package challenges.day2.loop.vocal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
         * Algoritmo que pida caracteres e imprima ‘VOCAL’ si son vocales y ‘NO VOCAL’ en caso contrario,
         *  el programa termina cuando se introduce un espacio
         * */
        Scanner sc = new Scanner(System.in);
        String VOWELS = "aeiou";
        String input = sc.next().toLowerCase(); // only read until the first space compared to nextLine() which reads until the end of the line

        String result = (input.matches(String.format("[%s]+", VOWELS))) ? "VOCAL" : "NO VOCAL";
        System.out.println(result);

        // regex ('["aeiou"]+' ) -> one or more repetitions of the characters in the string
    }
}

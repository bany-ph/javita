package challenges.loop.vocal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
         * Algoritmo que pida caracteres e imprima ‘VOCAL’ si son vocales y ‘NO VOCAL’ en caso contrario,
         *  el programa termina cuando se introduce un espacio
         * */

        Scanner sc = new Scanner(System.in);
        StringBuilder letters = new StringBuilder();
        String VOWELS = "aeiou";

        while(true){

            letters.append(sc.next());
            if(letters.toString().charAt(letters.length() - 1) == ' '){
                break;
            }
        }

      //  int random = (int) (Math.random() * (100 - 1 + 1)) + 1;
        //System.out.println(letters);
        String res = " ";
        for (int i = 0; i < letters.length() ; i++) {
            res = (VOWELS.indexOf(letters.charAt(i)) != -1) ? "VOWELS" : "NO VOWELS" ;
        }
        System.out.println(res);
    }
}

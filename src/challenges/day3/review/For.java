package challenges.day3.review;

public class For {
    public static void main(String[] args) {
        /*for:
           Patrón en pirámide Usa dos bucles for para imprimir:
                       *
                      ***
                     *****
                    *******
           */
        String tab = " ";
        String ouput ="";
        String e = "*";
        int lines = 5;

        for (int i = lines; i > 0; i--) {
            ouput +=  "\n" + tab.repeat(i)  + e ;
            e = "*" + e + "*";
        }
        System.out.println(ouput);
    }
}

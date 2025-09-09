package challenges.collection.cofre;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cofre cofre = new Cofre();
        while (true){
            try{
                System.out.println("1. get items \n2. get first item \n3. get last item \n4. change item \n5. exit");
                switch(sc.nextInt()){
                    case 1:
                        System.out.println(cofre.getItems());
                        break;
                    case 2:
                        System.out.println(cofre.getFirstItem());
                        break;
                    case 3:
                        System.out.println(cofre.getLastItem());
                        break;
                    case 4:
                        System.out.println("Enter the item to replace > ");
                        int replacement = sc.nextInt();
                        System.out.println("Enter the new item > ");
                        int newItem = sc.nextInt();
                        cofre.changeValueItem(newItem, replacement);
                        break;
                    case 5:
                        System.out.println("Bye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("No exist this option");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("enter a number");
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

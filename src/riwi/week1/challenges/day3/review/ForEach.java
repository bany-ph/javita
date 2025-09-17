package riwi.week1.challenges.day3.review;
import java.util.HashMap;
import java.util.Scanner;

public class ForEach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().toLowerCase().split(" ");
        HashMap<String,Integer> hashWords = new HashMap<>();

        for (String word : words){
            if(hashWords.containsKey(word)){
                hashWords.put(word,hashWords.get(word) + 1);
            }else{
                hashWords.put(word,1);
            }
        }


        System.out.println(hashWords);
    }
}

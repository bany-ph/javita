package riwi.week2.student.utils;

import java.util.List;
import java.util.function.Function;

public class FindElements {


    // Generics
    public static <T> T findByName(List<T> items, String name, Function<T,String> extractName ){
        return items.stream()
                .filter(item -> extractName.apply(item).equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public static <T> T findById(List<T> items, int id, Function<T,Integer> extractId){
        return items.stream()
                .filter(item -> extractId.apply(item) == id )
                .findFirst()
                .orElse(null);
    }
}

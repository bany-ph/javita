package riwi.week2.student.utils;

import riwi.week2.student.model.Course;

import java.util.List;
import java.util.function.Function;

public class FindElements {


    /**
     *  Search the first Object in a list whose name is equal
     *
     * @param <T> Generic Object type
     * @param extractName a Function which gets an Object and returns the Object name used it for comparing
     *
    * */
    public static <T> T findByName(List<T> items, String name, Function<T,String> extractName ){
        return items.stream()
                .filter(item -> extractName.apply(item).equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * Search the first Object in a list whose id is equal
     * */
    public static <T> T findById(List<T> items, int id, Function<T,Integer> extractId){
        return items.stream()
                .filter(item -> extractId.apply(item) == id )
                .findFirst()
                .orElse(null);
    }

}

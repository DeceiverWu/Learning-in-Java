package java8inaction.common;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 18:50
 */
public class FilterUtils {

    private FilterUtils() {}

    // Predicate
    public static <T> List<T> filter(List<T> inventory, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : inventory) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    // Function
    public static <T, R> List<R> map(List<T> list, Function<T, R> func) {
        List<R> res = new ArrayList<>();
        for (T t : list) {
            res.add(func.apply(t));
        }
        return res;
    }

    // Consumer
    public static <T> void forEach(List<T> list, Consumer<T> c){
        for(T t: list){
            c.accept(t);
        }
    }

}

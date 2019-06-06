package java8inaction.lambda;

import java8inaction.common.Dish;
import java8inaction.common.DishUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-05
 * Time: 17:43
 */
public class Filtering {
    public static void main(String...args){

        // Filtering with predicate
        List<Dish> vegetarianMenu =
                DishUtils.menu.stream()
                        .filter(Dish::isVegetarian)
                        .collect(Collectors.toList());

        vegetarianMenu.forEach(System.out::println);

        // Filtering unique elements
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        // Truncating a stream
        List<Dish> dishesLimit3 =
                DishUtils.menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .limit(3)
                        .collect(Collectors.toList());

        dishesLimit3.forEach(System.out::println);

        // Skipping elements
        List<Dish> dishesSkip2 =
                DishUtils.menu.stream()
                        .filter(d -> d.getCalories() > 300)
                        .skip(2)
                        .collect(Collectors.toList());

        dishesSkip2.forEach(System.out::println);
    }
}

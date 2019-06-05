package java8inaction.lambda;

import java8inaction.common.Apple;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 18:46
 */
public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        // filter green apples
        List<Apple> greenApples = filterGreenApples(inventory);
        System.out.println(greenApples);

        // filter heavy apples
        List<Apple> heavyApples = filterHeavyApples(inventory);
        System.out.println(heavyApples);

        // predicate apples ==> green apples
        List<Apple> greenApple2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApple2);

        // predicate apples ==> heavy > 150
        List<Apple> heavyApples1 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heavyApples1);

        //predicate apples ==> heavy < 80
        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() < 80);
        System.out.println(heavyApples2);


    }

    @Test
    public void test() {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> apples = inventory.stream()
                .filter((Apple a) -> a.getWeight() > 150)
                .collect(Collectors.toList());
        System.out.println(apples);
    }

    @Test
    public void test1() {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> appleList = inventory.parallelStream()
                .filter((Apple a) -> a.getWeight() > 150)
                .collect(Collectors.toList());
        System.out.println(appleList);
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}

package java8inaction.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-05
 * Time: 17:58
 */
public class Reducing {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,4,5,1,2);
        Integer sum = numbers.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        Integer product = numbers.stream().reduce(1, (x, y) -> x * y);
        System.out.println(product);

        Integer sum1 = numbers.stream().reduce(1, Integer::sum);
        System.out.println(sum1);

        Optional<Integer> optional = numbers.stream().reduce((x, y) -> x * y);
        System.out.println(optional.get());

        Optional<Integer> min = numbers.stream().min(Integer::min);
        System.out.println(min.get());

        Optional<Integer> max = numbers.stream().max(Integer::max);
        System.out.println(max.get());

        Integer reduce = numbers.stream().map(d -> 1).reduce(0, (x, y) -> x + y);
        System.out.println(reduce);

        long count = numbers.stream().count();
        System.out.println(count);
    }
}

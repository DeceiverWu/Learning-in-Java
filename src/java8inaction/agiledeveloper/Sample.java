package java8inaction.agiledeveloper;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-08-12
 * Time: 20:36
 */
public class Sample {

    public static void main(String[] args) {
        Order order = new Order(Arrays.asList(
                new OrderItem(1, 1225),
                new OrderItem(2, 983),
                new OrderItem(3, 1554)
        ));

        order.transformAndPrint(new Transformer<Stream<OrderItem>>() {

            @Override
            public Stream<OrderItem> transform(Stream<OrderItem> input) {
                return input.sorted(Comparator.comparing(OrderItem::getPrice));
            }
        });

        order.transformAndPrint(input -> input.sorted(Comparator.comparing(OrderItem::getPrice)));
    }
}

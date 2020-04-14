package java8inaction.agiledeveloper;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-08-12
 * Time: 20:30
 */
public class Order {

    List<OrderItem> items;

    public Order(List<OrderItem> orderItems) {
        items = orderItems;
    }

    public void transformAndPrint(Transformer<Stream<OrderItem>> transformOrderItems) {
        transformOrderItems.transform(items.stream())
                .forEach(System.out::println);
    }
}

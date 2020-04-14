package java8inaction.agiledeveloper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-08-12
 * Time: 18:53
 */
public class OrderItem {

    private final int id;
    private final int price;

    public OrderItem(int theId, int thePrice) {
        id = theId;
        price = thePrice;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return String.format("id: %d price: %d", id, price);
    }
}

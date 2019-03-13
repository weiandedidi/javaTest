package design.strategy.update;

/**
 * @author qidi
 * @date 2019-03-13 18:00
 */
public class VIP implements Custumer {
    private double price;

    @Override
    public double getPrice() {
        return price;
    }

    public VIP(double price) {
        this.price = price;
    }
}

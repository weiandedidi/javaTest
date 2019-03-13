package design.strategy.update;

/**
 * @author qidi
 * @date 2019-03-13 17:59
 */
public class Student implements Custumer {
    private double price;

    @Override
    public double getPrice() {
        return price;
    }

    public Student(double price) {
        this.price = price;
    }
}

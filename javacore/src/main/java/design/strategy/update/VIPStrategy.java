package design.strategy.update;

/**
 * VIP 打五折
 *
 * @author qidi
 * @date 2019-03-13 17:34
 */
public class VIPStrategy implements CustomerStrategy {

    @Override
    public double calculate(double price) {
        return price * 0.5;
    }
}

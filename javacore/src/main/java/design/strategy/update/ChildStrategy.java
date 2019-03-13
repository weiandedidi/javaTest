package design.strategy.update;

/**
 * 幼儿打7折
 *
 * @author qidi
 * @date 2019-03-13 17:35
 */
public class ChildStrategy implements CustomerStrategy {
    @Override
    public double calculate(double price) {
        return price * 0.7;
    }
}

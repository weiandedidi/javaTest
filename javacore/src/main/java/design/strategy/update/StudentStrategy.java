package design.strategy.update;

/**
 * 学生打8折
 *
 * @author qidi
 * @date 2019-03-13 17:33
 */
public class StudentStrategy implements CustomerStrategy {

    @Override
    public double calculate(double price) {
        return price * 0.8;
    }
}

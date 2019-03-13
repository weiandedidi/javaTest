package design.strategy.update;

/**
 * 顾客接口 计算打折价格
 *
 * @author qidi
 * @date 2019-03-13 17:31
 */
public interface CustomerStrategy {
    /**
     * 计算打折
     *
     * @param price
     * @return
     */
    public double calculate(double price);
}

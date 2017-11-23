package design.strategy.simple;

/**
 * 年龄在10周岁及以下的儿童可享受每张票减免10元的优惠（原始票价需大于等于20元）；
 *
 * @author: qidima
 * @date: 2017/11/23
 * Time: 9:42
 */
public class ChildDiscount implements IDiscountStrategy {
    @Override
    public double calculate(double price) {
        System.out.println("儿童票：");
        return price - 10;
    }
}

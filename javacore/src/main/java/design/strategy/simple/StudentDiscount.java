package design.strategy.simple;

/**
 * 学生凭学生证可享受票价8折优惠；
 *
 * @author: qidima
 * @date: 2017/11/23
 * Time: 9:43
 */
public class StudentDiscount implements IDiscountStrategy {
    @Override
    public double calculate(double price) {
        System.out.println("学生票： 8折");
        return price * 0.8;
    }
}

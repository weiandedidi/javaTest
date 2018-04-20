package design.strategy.simple;

/**
 * 影院VIP用户除享受票价半价优惠外还可进行积分，积分累计到一定额度可换取电影院赠送的奖品。
 * 该系统在将来可能还要根据需要引入新的打折方式。
 *
 * @author: qidima
 * @date: 2017/11/23
 * Time: 9:42
 */
public class VIPDiscount implements IDiscountStrategy {
    @Override
    public double calculate(double price) {
        System.out.println("VIP票：");
        System.out.println("增加积分！");
        return price * 0.5;
    }
}

package design.strategy.simple;

/**
 * 案例：
 * Sunny软件公司为某电影院开发了一套影院售票系统，在该系统中需要为不同类型的用户提供不同的电影票打折方式，
 * 具体打折方案如下：
 * (1) 学生凭学生证可享受票价8折优惠；
 * (2) 年龄在10周岁及以下的儿童可享受每张票减免10元的优惠（原始票价需大于等于20元）；
 * (3) 影院VIP用户除享受票价半价优惠外还可进行积分，积分累计到一定额度可换取电影院赠送的奖品。
 * 该系统在将来可能还要根据需要引入新的打折方式。
 *
 * 策略的环境类
 *
 * @author: qidima
 * @date: 2017/11/23
 * Time: 9:38
 */
public class TicketContext {
    //策略类
    IDiscountStrategy strategy;

    public void setStrategy(IDiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double discount(double price){
        return strategy.calculate(price);
    }

}

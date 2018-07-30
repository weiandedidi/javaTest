package design.strategy.simple;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2017/11/23
 * Time: 10:18
 */
public class Client {
    public static void main(String[] args) {
        TicketContext context = new TicketContext();
        double originalPrice = 60.0;
        double currentPrice;

        System.out.println("原始价为：" + originalPrice);
        System.out.println("---------------------------------");

        //学生折扣
        IDiscountStrategy strategy = new StudentDiscount();
        //这里可以做成配置文件类
        context.setStrategy(strategy);
        currentPrice = context.discount(originalPrice);
        System.out.println("折后价为：" + currentPrice);
    }
}

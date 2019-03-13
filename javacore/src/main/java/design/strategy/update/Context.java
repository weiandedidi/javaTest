package design.strategy.update;

/**
 * 注册策略的环境控制
 * 共享策略模式
 *
 * @author: qidima
 * @date: 2017/11/23
 * Time: 10:58
 */
public class Context {
    private CustomerStrategy customerStrategy;

    public double discount(double price) {
        return customerStrategy.calculate(price);
    }

    public Context(CustomerStrategy customerStrategy) {
        this.customerStrategy = customerStrategy;
    }
}

package design.stats.bankDemo;

/**
 * 客户端测试代码
 *
 * @author: qidima
 * @date: 2017/12/14
 * Time: 15:31
 */
public class Client {
    public static void main(String[] args) {
        Account acc = new Account("段誉",0.0);

        acc.deposit(1000);
        acc.withdraw(2000);
        acc.deposit(3000);
        acc.withdraw(4000);
        acc.withdraw(1000);
        acc.computeInterest();
    }
}

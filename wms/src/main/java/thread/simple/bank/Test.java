package thread.simple.bank;

/**
 * 假设你的银行账户有100元，并且你和你的妻子两人都知道账户密码，
 * 如果某一天，你去取100元，银行系统会先查看你的账户够不够100元，
 * 明显你是满足条件的，但是，如果此时你的妻子也需要去取100元，
 * 并且你的取钱线程刚好因为某些状况被打断了（这时系统还来不及修改你的账户余额），
 * 所以你的妻子去取钱时也满足条件，所以她完成了取钱动作，
 * 而你取钱线程恢复之后，你也将完成取钱动作。
 * 结果：由于两个人是先判断后取钱，判断后的动作没提交，同时有人在操作，就会有线程安全问题。一人取了100
 *
 * @author: qidima
 * @date: 2018/6/4
 * Time: 10:24
 */
public class Test {
    public static void main(String[] args) {
        Account account = new Account(100);
        Account account1 = new Account(100);
        AccountThread AccountThread1 = new AccountThread(account, 1000);
//        AccountThread AccountThread2 = new AccountThread(account, 0);
        AccountThread AccountThread2 = new AccountThread(account1, 0);
        AccountThread1.start();
        AccountThread2.start();
    }
}

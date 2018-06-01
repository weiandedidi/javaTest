package thread.simple;

/**
 * 两个人AB通过一个账户A在柜台取钱和B在ATM机取钱！
 *
 * @author: qidima
 * @date: 2018/6/1
 * Time: 20:18
 */
public class Test {
    public static void main(String[] args) {
        // 实力化同一个账户
        Account account = new Account();
        PersonA pA = new PersonA(account);
        PersonB pB = new PersonB(account);
        Thread threadA = new Thread(pA);
        Thread threadB = new Thread(pB);
        threadA.start();
        threadB.start();
    }
}

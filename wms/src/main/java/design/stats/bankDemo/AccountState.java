package design.stats.bankDemo;

/**
 * 充当抽象状态角色
 *
 * @author: qidima
 * @date: 2017/12/13
 * Time: 17:57
 */
public abstract class AccountState {
    protected Account acc;

    public AccountState(Account acc) {
        this.acc = acc;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void computeInterest();
    public abstract void stateCheck();
}

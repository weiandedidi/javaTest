package design.stats.bankDemo;

/**
 * 如果账户中余额小于0，并且大于-2000，则账户的状态为透支状态(Overdraft State)，此时用户既可以向该账户存款也可以从该账户取款，但需要按天计算利息；
 *
 * @author: qidima
 * @date: 2017/12/14
 * Time: 14:52
 */
public class OverdraftState extends AccountState {


    public OverdraftState(Account acc) {
        super(acc);
    }

    @Override
    public void deposit(double amount) {
        acc.setBalance(acc.getBalance() + amount);
        stateCheck();
    }

    @Override
    public void withdraw(double amount) {
        acc.setBalance(acc.getBalance() - amount);
        stateCheck();
    }

    @Override
    public void computeInterest() {
        System.out.println("计算利息！");
    }

    @Override
    public void stateCheck() {
        if (acc.getBalance() > 0) {
            acc.setState(new NormalStatus(this.acc));
        }
        else if (acc.getBalance() == -2000) {
            acc.setState(new RestrictedState(this.acc));
        }
        else if (acc.getBalance() < -2000) {
            System.out.println("操作受限！");
        }
    }
}

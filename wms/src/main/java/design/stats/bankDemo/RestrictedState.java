package design.stats.bankDemo;

/**
 * 如果账户中余额等于-2000，那么账户的状态为受限状态(Restricted State)，此时用户只能向该账户存款，不能再从中取款，同时也将按天计算利息；
 *
 * @author: qidima
 * @date: 2017/12/14
 * Time: 14:52
 */
public class RestrictedState extends AccountState {
    public RestrictedState(Account acc) {
        super(acc);
    }

    @Override
    public void deposit(double amount) {
        acc.setBalance(acc.getBalance() + amount);
        stateCheck();
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("帐号受限，取款失败");
    }

    @Override
    public void computeInterest() {
        System.out.println("计算利息！");
    }

    @Override
    public void stateCheck() {
        if (acc.getBalance() > 0) {
            acc.setState(new NormalStatus(this.acc));
        } else if (acc.getBalance() > -2000) {
            acc.setState(new OverdraftState(this.acc));
        }
    }
}

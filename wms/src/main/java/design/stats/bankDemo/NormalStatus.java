package design.stats.bankDemo;

/**
 * 如果账户中余额大于等于0，则账户的状态为正常状态(NormalState State)，此时用户既可以向该账户存款也可以从该账户取款；
 *
 * @author: qidima
 * @date: 2017/12/14
 * Time: 14:36
 */
public class NormalStatus extends AccountState {


    public NormalStatus(Account acc) {
        super(acc);
    }

    /**
     * 存
     *
     * @param amount
     */
    @Override
    public void deposit(double amount) {
        acc.setBalance(amount + acc.getBalance());
        stateCheck();
    }

    @Override
    public void withdraw(double amount) {
        acc.setBalance(acc.getBalance() - amount);
        stateCheck();
    }

    @Override
    public void computeInterest() {
        System.out.println("正常状态，无须支付利息！");
    }

    @Override
    public void stateCheck() {
        if (acc.getBalance() > -2000 && acc.getBalance() <= 0){
            acc.setState(new OverdraftState(this.acc));
        }else if (acc.getBalance() == -2000){
            acc.setState(new RestrictedState(this.acc));
        }else {
            System.out.println("操作受限制！");
        }
    }
}

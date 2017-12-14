package design.stats.contextControl;

import java.util.HashMap;

/**
 * 在状态模式中实现状态转换时，具体状态类可通过调用环境类Context的setState()方法进行状态的转换操作，也可以统一由环境类Context来实现状态的转换
 * 增加新的具体状态类可能需要修改其他具体状态类或者环境类的源代码，否则系统无法转换到新增状态。
 * <p>
 * 案例：
 * 用户单击“放大镜”按钮之后屏幕将放大一倍（2倍），再点击一次“放大镜”按钮屏幕再放大一倍（4倍大小），第三次点击该按钮后屏幕将还原到默认大小。
 *
 * 此种方式用的不多
 *
 * @author: qidima
 * @date: 2017/12/14
 * Time: 16:33
 */
public class Screen {
    //枚举状态，在状态间转换
    private State currentState, normalState, largerState, largestState;
    //状态跳转机制规则

    public Screen() {
        this.normalState = new NormalState(); //创建正常状态对象
        this.largerState = new LargerState(); //创建二倍放大状态对象
        this.largestState = new LargestState(); //创建四倍放大状态对象
        this.currentState = normalState; //设置初始状态
        this.currentState.display();
    }

    public void setState(State state) {
        this.currentState = state;
    }

    //单击事件处理方法，封转了对状态类中业务方法的调用和状态的转换

    public void onClick() {
        if (this.currentState == normalState) {
            this.setState(largerState);
            this.currentState.display();
        }
        else if (this.currentState == largerState) {
            this.setState(largestState);
            this.currentState.display();
        }
        else if (this.currentState == largestState) {
            this.setState(normalState);
            this.currentState.display();
        }
    }
}

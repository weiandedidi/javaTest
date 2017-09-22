package design.stats;

/**
 * context维护state实例
 * Created by qidima on 2017/6/19.
 */
public class Context {
    //持有一个State类型的对象实例
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Context() {
    }

    /**
     * 用户感兴趣的接口方法
     */
    public void request(String sampleParameter) {
        //转调state来处理
        state.handle(sampleParameter);
    }
}

package design.stats.demo;

/**
 * 状态类
 * Created by qidima on 2017/6/19.
 */
public abstract interface State {
    /**
     * 状态对应的处理
     */
    public void handle(String sampleParameter);
}

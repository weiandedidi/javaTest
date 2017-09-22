package design.stats;

/**
 * 休息状态
 * Created by qidima on 2017/6/19.
 */
public class RestState implements State {


    public void handle(String sampleParameter) {
        System.out.println("休息状态");
    }
}

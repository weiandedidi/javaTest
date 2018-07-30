package exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 测试内存溢出的情况 out of memory error
 * 虚拟机运行参数
 * -verbose:gc -Xms20m -Xmx20m -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 * @author: qidima
 * @date: 2018/4/23
 * Time: 14:44
 */
public class MyHeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}

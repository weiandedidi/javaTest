package lock.shared.zookeeper;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 伪造的有限资源类
 * 用火车票模拟
 *
 * @author qidi
 * @date 2019-01-18 15:02
 */
public class FakeLimitedResource {
    /**
     * 还有250张票
     */
    private Integer ticket = 250;

    /**
     * 使用火车票
     *
     * @throws InterruptedException
     */
    public void use() throws InterruptedException {

        try {
            System.out.println("火车票还剩" + (--ticket) + "张！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

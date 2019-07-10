package lock.shared.zookeeper.noreentrantlock;

import lock.shared.zookeeper.FakeLimitedResource;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 客户端的测试类
 *
 * @author qidi
 * @date 2019-01-18 15:23
 */
public class LockingExample {

    private static final int QTY = 5;
    private static final int REPETITIONS = QTY * 10;
    private static final String CONNECTION_STRING = "172.18.83.167:2181";
    private static final String PATH = "/examples/locks";

    public static void main(String[] args) {

        //FakeLimitedResource模拟某些外部资源，这些外部资源一次只能由一个进程访问
        final FakeLimitedResource resource = new FakeLimitedResource();

        ExecutorService service =Executors.newFixedThreadPool(QTY);

        try {
            for (int i = 0; i < QTY; ++i) {
                final int index = i;

                Callable<Void> task = () -> {
                    CuratorFramework client = CuratorFrameworkFactory.newClient(CONNECTION_STRING, new ExponentialBackoffRetry(1000, 3, Integer.MAX_VALUE));

                    try {
                        client.start();

                        ExampleClientNotReentrantLock example = new ExampleClientNotReentrantLock(client, PATH, resource, "Client " + index);
                        for (int j = 0; j < REPETITIONS; ++j) {
                            example.doWork(10, TimeUnit.SECONDS);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } catch (Exception e) {
                        e.printStackTrace();
                        // log or do something
                    } finally {
                        CloseableUtils.closeQuietly(client);
                    }
                    return null;

                };
                service.submit(task);
            }
            service.shutdown();
            service.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

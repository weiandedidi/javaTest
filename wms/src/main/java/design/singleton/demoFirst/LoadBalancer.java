package design.singleton.demoFirst;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 将负载均衡器LoadBalancer设计为单例类
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/10/10
 * Time: 17:19
 */
public class LoadBalancer {
    //私有静态成员变量，存储唯一实例
    private static LoadBalancer instance = null;
    //服务器集合
    private List serverList = null;

    //私有构造函数
    private LoadBalancer() {
        serverList = new ArrayList();
    }

    //私有静态成员方法，返回唯一实例
    public static LoadBalancer getLoadBalancer() {
        if (null == instance) {
            instance = new LoadBalancer();
        }
        return instance;
    }

    //增加服务器
    public void addServer(String server) {
        serverList.add(server);
    }

    //删除服务器
    public void removeServer(String server) {
        serverList.remove(server);
    }

    //使用Random类随机获取服务器
    public String getServer() {
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        return (String) serverList.get(i);
    }
}

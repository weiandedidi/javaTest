package zookeeperConfig;

/**
 * @author qidi
 * @date 2018-12-19 20:30
 */
public class ZkConfigTest {
    public static void main(String[] args) {
        ZkConfigManager manager = new ZkConfigManager();
        Config config = manager.downLoadConfigFromDB();
        System.out.println("....加载数据库配置...." + config.toString());
        manager.syncConfigToZk();
        System.out.println("....同步配置文件到zookeeper....");

        //歇会，这样看比较清晰
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        manager.upLoadConfigToDB("cwhcc", "333555");
        System.out.println("....修改配置文件...." + config.toString());
        manager.syncConfigToZk();
        System.out.println("....同步配置文件到zookeeper....");


    }

}

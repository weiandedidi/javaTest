package zookeeperConfig;

import org.I0Itec.zkclient.ZkClient;

/**
 * 配置管理中心
 *
 * @author qidi
 * @date 2018-12-19 20:22
 */
public class ZkConfigManager {
    private Config config;

    /**
     * 从数据库加载配置
     *
     * @return
     */
    public Config downLoadConfigFromDB() {
        config = new Config("qidi", "123456");
        return config;
    }

    /**
     * 配置文件上传到数据库
     */
    public void upLoadConfigToDB(String nm, String pw) {
        if (config == null) {
            config = new Config();
        }
        config.setName(nm);
        config.setPassword(pw);
        //updateDB
    }

    /**
     * 配置文件同步到zookeeper
     */
    public void syncConfigToZk() {
        ZkClient zk = new ZkClient("localhost:2181");
        if (!zk.exists("/zkConfig")) {
            zk.createPersistent("/zkConfig", true);
        }
        zk.writeData("/zkConfig", config);
        zk.close();
    }

}

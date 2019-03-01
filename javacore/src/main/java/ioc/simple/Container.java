package ioc.simple;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 各种汽车管理的容器，就是spring的applicationContext
 * <p>
 * 就是维护了一个<String,Object>  class名字-class的实例
 *
 * @author qidi
 * @date 2019-03-01 16:56
 */
public class Container {
    /**
     * 非单例模式的map
     */
    private final Map<String, Object> beanMap = new ConcurrentHashMap(16);
    /**
     * 单例模式的map
     */
    private final Map<String, Object> singletonBeanMap = new ConcurrentHashMap<>(16);

    public void init() {
        //模拟spring完成扫描后，把bean装入容器  先不写入本田的属性，延迟写入
        HondaCar hondaCar = new HondaCar();
        this.beanMap.put("hondaCar", hondaCar);

        //模拟单例的map
        HondaCar car = new HondaCar("单例hondaCar");
        this.singletonBeanMap.put("hondaCar", car);
    }

    public Map<String, Object> getBeanMap() {
        return beanMap;
    }

    public Map<String, Object> getSingletonBeanMap() {
        return singletonBeanMap;
    }
}

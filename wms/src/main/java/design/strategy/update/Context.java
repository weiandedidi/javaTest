package design.strategy.update;

import java.util.HashMap;

/**
 * 注册策略的环境控制
 * 共享策略模式
 *
 * @author: qidima
 * @date: 2017/11/23
 * Time: 10:58
 */
public class Context {
    private static HashMap<Object, IStrategy> strategyMap = new HashMap<Object, IStrategy>();

    public static IStrategy getStratgy(Object key) {
        return strategyMap.get(key);
    }

    public static void addStrategyMap(Object key, IStrategy strategy) {
        strategyMap.put(key, strategy);
    }

    //使用方法
    public static void operation(Object key){
        strategyMap.get(key).operation();
    }
}

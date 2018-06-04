package util.optimizeMap;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock可以用来提高某些集合的并发性能。
 * 当集合比较大，并且读比写频繁时，可以使用该类
 * TreeMap使用ReentrantReadWriteLock进行封装成并发性能提高的一个例子
 *
 * @author: qidima
 * @date: 2018/6/4
 * Time: 14:19
 */
public class RWDictionary {
    private final Map<String, Data> m = new TreeMap<String, Data>();
    /**
     * 构造一个读写锁
     */
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public Data get(String key) {
        r.lock();
        try {
            return m.get(key);
        } finally {
            r.unlock();
        }
    }

    public String[] allKeys() {
        r.lock();
        try {
            return m.keySet().toArray(new String[m.keySet().size()]);
        } finally {
            r.unlock();
        }
    }

    public Data put(String key, Data value) {
        w.lock();
        try {
            return m.put(key, value);
        } finally {
            w.unlock();
        }
    }

    public void clear() {
        w.lock();
        try {
            m.clear();
        } finally {
            w.unlock();
        }
    }


}

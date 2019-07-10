# 锁的学习

## 读写锁
见 ReentrantReadWriteLock

## 死锁
DeadLockDemo 并使用JConsole 或者jvisualVM查看

## 公平锁
fair和unFair见可重入锁的ReentrantLock 的 公平获取和非公平获取

- 公平锁： 线程获取锁的顺序是按照线程加锁的顺序来分配的，即先来先得的FIFO先进先出顺序

- 非公平锁：一种获取锁的抢占机制，是随机获取锁的，和公平锁的区别就是先来的不一定先得到锁，导致某些线程可能一直拿不到锁，所以是不公平的

例如ReentrantLock，公平锁有请求队列，进行排队，而非公平锁没有

## 悲观锁 
数据库的表、行、库锁

## 乐观锁
核心思想，类似于AtomicInteger 包装类的原子操作，核心是通过比较 资源版本号 vs 线程拿到的版本号 的新旧，然后决定是否进行更新操作
核心方法compareAndSet  简称CAS(Compare and Swap) 方法 
需要考虑的问题： i++问题 

>CAS的思想很简单：三个参数，一个当前内存值V、旧的预期值A、即将更新的值B，当且仅当预期值A和内存值V相同时，将内存值修改为B并返回true，否则什么都不做，并返回false。

## 分布式锁

使用zookeeper进行锁


```java
    /**
     * 不可重入锁 Shared Lock
     * http://curator.apache.org/curator-recipes/shared-lock.html
     */
    private final InterProcessSemaphoreMutex lock;
    /**
     * 可重入读写锁 Shared Reentrant Read Write Lock
     * http://curator.apache.org/curator-recipes/shared-reentrant-read-write-lock.html
     */
    private final InterProcessReadWriteLock lock;
    /**
     * 共享信号量 Shared Semaphore
     */
    private final InterProcessSemaphoreV2 lock;
    /**
     * 多共享锁 Multi Shared Lock
     */
    private final InterProcessMultiLock lock;
```

[分布式锁使用](https://blog.csdn.net/qq_34021712/article/details/82878396)


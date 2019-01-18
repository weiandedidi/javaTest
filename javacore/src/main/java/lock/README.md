# 锁的学习

## 读写锁
见 ReentrantReadWriteLock

## 死锁
DeadLockDemo 并使用JConsole 或者jvisualVM查看

## 公平锁
fair和unFair见可重入锁的ReentrantLock 的 公平获取和非公平获取

## 悲观锁 
数据库的表、行、库锁

## 乐观锁
核心思想，类似于AtomicInteger 包装类的原子操作，核心是通过比较 资源版本号 vs 线程拿到的版本号 的新旧，然后决定是否进行更新操作
核心方法compareAndSet  简称CAS(Compare and Swap) 方法 
需要考虑的问题： i++问题 

>CAS的思想很简单：三个参数，一个当前内存值V、旧的预期值A、即将更新的值B，当且仅当预期值A和内存值V相同时，将内存值修改为B并返回true，否则什么都不做，并返回false。

## 分布式锁

使用zookeeper进行锁
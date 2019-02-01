# redisson

Redisson是架设在[Redis](https://baike.baidu.com/item/Redis)基础上的一个Java驻内存数据网格（In-Memory Data Grid）。【Redis官方推荐】

Redisson在基于NIO的[Netty](https://baike.baidu.com/item/Netty)框架上，充分的利用了Redis键值数据库提供的一系列优势，在Java实用工具包中常用接口的基础上，为使用者提供了一系列具有分布式特性的常用工具类。使得原本作为协调单机多线程并发程序的工具包获得了协调分布式多机多线程并发系统的能力，大大降低了设计和研发大规模分布式系统的难度。同时结合各富特色的分布式服务，更进一步简化了分布式环境中程序相互之间的协作。

## 适用场景

主要适用于以下几种场景：

分布式应用，缓存，分布式会话，分布式任务/服务/延迟执行服务，Redis客户端



# springboot的redisson的配置

## 步骤：

### 1.pom依赖

**For JDK 1.8+**

```xml
<dependency>
    <groupId>org.redisson</groupId>
    <artifactId>redisson-spring-boot-starter</artifactId>
    <version>3.10.1</version>
</dependency>
```

**For JDK 1.6+**

```xml
<dependency>
    <groupId>org.redisson</groupId>
    <artifactId>redisson-spring-boot-starter</artifactId>
    <version>2.15.1</version>
</dependency>
```

### 2.配置文件**application.settings**配置

配置目录

```shell

├── pom.xml
├── src
    ├── main
        ├── java
        │   └── com
        │       └── qidi
        │           └── bootdemo
        │               ├── BootdemoApplication.java
        └── resources
            ├── application.properties
            ├── application.yaml
            └── redisson
                └── redisson.yaml
```

**application.properties的配置**

```properties
# common spring boot settings
spring.
# Redisson settings  resource目录下redisson文件夹的redisson.yaml文件
spring.redis.redisson.config=classpath:redisson/redisson.yaml
```

### 3.详细使用见

`com.qidi.bootdemo.lock.LockService`[分布式锁](https://github.com/weiandedidi/javaStu/raw/master/bootdemo/src/main/java/com/qidi/bootdemo/lock/LockService.java)


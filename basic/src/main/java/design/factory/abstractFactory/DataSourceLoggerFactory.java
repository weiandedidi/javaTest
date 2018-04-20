package design.factory.abstractFactory;

/**
 * 数据库日志记录器工厂类：具体工厂
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/9/26
 * Time: 下午9:45
 */
public class DataSourceLoggerFactory implements LoggerFactory{

    public Logger createLogger() {
        //连接数据库，代码省略
        //创建数据库日志记录器对象
        Logger logger = new DateSourceLogger();
        //初始化数据库日志记录器，代码省略
        return logger;
    }
}

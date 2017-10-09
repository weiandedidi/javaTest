package design.factory.abstactFactory;

/**
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/10/9
 * Time: 16:00
 */
public class DataSourceFactory implements LoggerFactory {
    public Logger createLogger() {
        //连接数据库，代码省略
        //创建数据库日志记录器对象
        Logger logger = new DataSourceLogger();
        //初始化数据库日志记录器，代码省略(进阶版可查看log4j的日志注入)
        return logger;
    }
}

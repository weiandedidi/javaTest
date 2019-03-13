package design.factory.abstractFactory;

/**
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/9/26
 * Time: 下午9:47
 */
public class ServerLoggerFactory implements LoggerFactory{
    public Logger createLogger() {
        //创建服务器日志记录器对象
        Logger logger = new ServerLogger();
        //创建文件，代码省略
        return logger;
    }
}

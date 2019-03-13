package design.factory.abstactFactory;

/**
 * 服务器日志工厂
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/10/9
 * Time: 15:59
 */
public class ServerLoggerFactory implements LoggerFactory{
    public Logger createLogger() {
        //创建日志记录器对象
        Logger logger = new ServerLogger();
        //创建文件，代码省略
        return logger;
    }
}

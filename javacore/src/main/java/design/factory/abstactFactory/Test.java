package design.factory.abstactFactory;

/**
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/10/9
 * Time: 16:13
 */
public class Test {
    public static void main(String[] args) {
        LoggerFactory factory;
        Logger logger;
        factory = new DataSourceFactory(); //可引入配置文件实现
        logger =factory.createLogger();
        logger.writeLog();
    }
}

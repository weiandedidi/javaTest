package design.factory.abstactFactory;

/**
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/9/26
 * Time: 15:56
 */
public interface LoggerFactory{
    /**
     * 日志工厂
     * @return
     */
    public Logger createLogger();
}
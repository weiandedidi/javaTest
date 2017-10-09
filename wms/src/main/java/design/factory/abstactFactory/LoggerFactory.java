package design.factory.abstactFactory;

/**
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/9/26
 * Time: 15:56
 */
public interface LoggerFactory{
    /**
     * 创建日志
     * @return
     */
    public Logger createLogger();
}
package design.factory.abstractFactory;

/**
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/9/26
 * Time: 下午9:48
 */
public class ServerLogger implements Logger{
    public void writeLog() {
        System.out.println("服务器日志记录。");
    }
}

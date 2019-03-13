package design.factory.abstractFactory;

/**
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/9/26
 * Time: 下午9:47
 */
public class DateSourceLogger implements Logger{
    //数据库日志记录器：具体产品
    public void writeLog() {
        System.out.println("文件日志记录");
    }
}

package design.factory.abstactFactory;

/**
 * Created with IntelliJ IDEA.
 * User: qidima
 * Date: 2017/9/26
 * Time: 15:49
 */
public class DataSourceLogger implements Logger {

    public void writeLog() {
        System.out.println("write dataSource log");
    }
}

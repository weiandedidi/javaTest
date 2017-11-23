package design.proxy;

/**
 * 日志对象
 *
 * @author: qidima
 * @date: 2017/11/23
 * Time: 17:55
 */
public class Logger {
    //模拟实现日志记录
    public void log(String userId) {
        System.out.println("更新数据库，用户'" + userId + "'查询次数加1！");
    }
}

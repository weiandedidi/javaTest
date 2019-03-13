package design.prototype.simple;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * @author maqidi
 * Date: 2017/10/19
 * Time: 10:52
 */
public class Client {
    public static void main(String[] args) {
        WeeklyLog weeklyLog = new WeeklyLog();  //创建原型
        weeklyLog.setName("周报名字");
        weeklyLog.setDate(new Date());
        weeklyLog.setContent("周工作内容");

        System.out.println("****周报****");
        System.out.println("周次：" + weeklyLog.getDate());
        System.out.println("姓名：" + weeklyLog.getName());
        System.out.println("内容：" + weeklyLog.getContent());
        System.out.println("--------------------------------");

        //克隆对象
        WeeklyLog secondLog = weeklyLog.clone();
        secondLog.setName("第二周");
        System.out.println("****周报****");
        System.out.println("周次：" + secondLog.getDate());
        System.out.println("姓名：" + secondLog.getName());
        System.out.println("内容：" + secondLog.getContent());
        System.out.println("--------------------------------");

        System.out.println(secondLog == weeklyLog);
        System.out.println(secondLog.equals(weeklyLog));

        System.out.println(weeklyLog.getName());


    }
}

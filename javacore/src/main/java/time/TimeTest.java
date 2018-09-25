package time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Java获取 ISO 8601格式时间
 * User: qidi
 * Date: 2018/9/19
 * Time: 下午7:35
 */
public class TimeTest {

    public static String getISO8601TimeFormat(Date date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+08:00'");
        String nowAsISO = df.format(date);
        return nowAsISO;
    }

    public static long getISO8601Timestamp(String time) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'+08:00'");
        Date date = df.parse(time);
        return date.getTime();
    }

    public static long getTime(String time) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date date = df.parse(time);
        return date.getTime();
    }

    /**
     * 获取前一个小时的整点数字
     *
     * @param date 指定时间
     * @return 前一小时整点数字
     */
    public static Integer getPreviousClock(Date date) {
        Calendar calendar = Calendar.getInstance();
        Integer clock = calendar.get(Calendar.HOUR_OF_DAY) - 1;
        return clock;
    }


    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(getISO8601TimeFormat(date));
        System.out.println(getISO8601Timestamp("2018-09-19T19:41:10+08:00"));
        System.out.println(getTime("20180827")/1000);

        System.out.println(getPreviousClock(new Date()));
    }
}

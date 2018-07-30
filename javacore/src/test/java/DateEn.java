import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 英国时间转化
 *
 * @author: qidima
 * @date: 2018/6/27
 * Time: 15:12
 */
public class DateEn {
    public static void main(String[] args) throws ParseException {
        String liveTime = "Jun 22, 2018 10:31:55 AM";
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy K:m:s a", Locale.ENGLISH);
        Date d = sdf.parse(liveTime);
        System.out.println(d);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = format.format(d);
        System.out.println(s);
    }
}

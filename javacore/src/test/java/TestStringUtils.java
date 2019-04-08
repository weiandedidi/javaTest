import org.apache.commons.lang3.StringUtils;

/**
 * @author qidi
 * @date 2019-04-08 17:01
 */
public class TestStringUtils {
    public static void main(String[] args) {
        System.out.println(StringUtils.leftPad("abcdefg", 20, "*_"));
        System.out.println(StringUtils.leftPad("1234", 10, "0"));
        String num = StringUtils.leftPad("1234", 10, "0");
        int x = Integer.parseInt(num);
        System.out.println(x);
    }
}

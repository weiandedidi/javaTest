import org.apache.commons.lang.StringUtils;

/**
 * 空和空字符串
 *
 * @author qidi
 * @date 2019-07-10 20:01
 */
public class StringUtilsTest {
    public static void main(String[] args) {

        String str = " ";
        System.out.println(StringUtils.isEmpty(str));
        System.out.println(StringUtils.isBlank(str));
    }
}

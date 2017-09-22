import java.util.regex.Pattern;

/**
 * Created by qidima on 2017/7/6.
 */
public class TestRegex {
    public static void main(String[] args) {
        String regExp = "^1(3|4|5|7|8])\\d{9}$";
        System.out.println(Pattern.matches(regExp,"1655465315".trim()));
        String regExp2 = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
        System.out.println(Pattern.matches(regExp,"1655465315"));
    }
}

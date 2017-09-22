package util.regular;

import java.util.regex.Pattern;

/**
 * Created by qidima on 2017/6/23.
 */
public class RegularDemo {
    public static void main(String[] args) {
        String regix = "/(.*)/$";
        Pattern pattern = Pattern.compile(regix);
        Pattern s = Pattern.compile("$1");
        String json = "/news_ying_1.json";
    }
}

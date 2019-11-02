import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author qidi
 * @date 2019-10-24 19:50
 */
public class DelimiterDemo {
    public static void main(String[] args) {
        String str = "{\n" +
                "  \"body\": {\n" +
                "    \"code\": \"1\",\n" +
                "    \"status\": 3,\n" +
                "    \"taskCode\": \"5\",\n" +
                "    \"message\": \"小车已经有任务了\"\n" +
                "  },\n" +
                "  \"head\": {\n" +
                "    \"interfaceName\": \"agvCallback\",\n" +
                "    \"model\": \"EVO-RCS\",\n" +
                "    \"request_id\": \"1571917107130\",\n" +
                "    \"serialNo\": \"quicktron01\",\n" +
                "    \"type\": \"response\",\n" +
                "    \"vendor\": \"hikvision\",\n" +
                "    \"version\": \"0.0.1-SNAPSHOT\"\n" +
                "  }\n" +
                "}";

        System.out.println(str);

        Pattern p = Pattern.compile("\\s*|\t|\r|\n");
        Matcher m = p.matcher(str);
        str = m.replaceAll("");
        System.out.println(str);


    }
}

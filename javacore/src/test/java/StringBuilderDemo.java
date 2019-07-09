import org.apache.commons.lang.StringUtils;

/**
 * @author qidi
 * @date 2019-07-04 19:13
 */
public class StringBuilderDemo
{
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("1").append(" ");
        sb.append("2");
        System.out.println(sb.toString());
    }
}

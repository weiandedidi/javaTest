import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

/**
 * @author qidi
 * @date 2020-05-18 11:49
 */
public class ApacheUtilsTest {

    @Test
    public void testNumberUtils() {

        Aoo aoo = new Aoo("qi", "14");
        System.out.println(NumberUtils.toInt(aoo.getAge(), 0));
    }

    @Data
    @AllArgsConstructor
    class Aoo {
        private String name;
        private String age;
    }
}

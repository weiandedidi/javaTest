import com.google.common.collect.Maps;
import org.apache.commons.lang3.BooleanUtils;

import java.text.NumberFormat;
import java.util.Map;

/**
 * @author qidi
 * @date 2019-08-30 19:57
 */
public class ApacheUtils {
    public static void main(String[] args) {
        System.out.println(BooleanUtils.isTrue(null));
        System.out.println(BooleanUtils.isTrue(new Boolean(true)));
        System.out.println(BooleanUtils.isTrue(new Boolean(false)));
        Long id = new Long(1);
        System.out.println(1L == id);

        Map<String, Object> map = Maps.newHashMap();
        System.out.println(map.entrySet().stream().filter(o -> o.getValue().equals(1)).findFirst().orElse(null));
    }
}

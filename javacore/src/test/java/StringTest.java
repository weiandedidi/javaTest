import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qidi
 * @date 2020-06-01 20:08
 */
public class StringTest {
    public static void main(String[] args) {
        String str = "15,123,";
        List<Long> boxIdList = Lists.newArrayList(StringUtils.split(str, ",")).stream().filter(item -> NumberUtils.isNumber(item)).map(Long::parseLong).collect(Collectors.toList());
        System.out.println(boxIdList);

        List<Integer> integerList = Lists.newArrayList(1, 2, 3);
        List<Integer> aa = integerList.stream().filter(o -> o > 10).collect(Collectors.toList());
        List<Integer> integers = Lists.newArrayList();
        integers.addAll(aa);
        System.out.println(CollectionUtils.isEmpty(integers));

        List<Integer> idList = new ArrayList<Integer>();
        List<Integer> tempList = idList.stream().collect(Collectors.toList());
        System.out.println(JSON.toJSONString(tempList));


    }

    public static String connectIntListBySymbol(List<Integer> ids, String symbol) {
        String data = StringUtils.EMPTY;
        if (CollectionUtils.isNotEmpty(ids)) {
            data = StringUtils.join(ids, symbol);
        }
        return data;
    }
}

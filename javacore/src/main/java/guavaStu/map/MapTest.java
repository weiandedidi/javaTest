package guavaStu.map;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @author qidi
 * @date 2018-12-29 15:12
 */
public class MapTest {
    public static void main(String[] args) {


        Map<Integer, Map<Long, List<String>>> map = Maps.newHashMap();

        for (int i = 0; i < 10; i++) {
            map.put(i, Maps.newHashMap());
            for (long j = 0; j < 10; j++) {
                List<String> list = Lists.newArrayList();
                list.add(Integer.toString((int) j));
                map.get(i).put(j, list);
            }
        }

        System.out.println(JSON.toJSONString(map));


    }

}


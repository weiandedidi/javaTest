import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author qidi
 * @date 2019-05-29 20:54
 */
public class JSONArray {
    public static void main(String[] args) {
        List<Aoo> aooList = Lists.newArrayList(new Aoo("1", 1), new Aoo("2", 2));

        System.out.println(JSON.toJSONString(aooList));

        Aoo aoo = new Aoo("你好", 4);
        Object o = JSON.toJSON(aoo);

        Aoo aoo1 = JSON.parseObject(JSON.toJSONString(o), Aoo.class);
        System.out.println(aoo1.getAge());

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Aoo {
        private String name;
        private Integer age;
    }
}

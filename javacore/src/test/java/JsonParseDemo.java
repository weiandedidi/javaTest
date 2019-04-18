import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author qidi
 * @date 2019-04-09 19:36
 */
public class JsonParseDemo {
    public static void main(String[] args) {

        String json = "{\"name\":\"ma\",\"age\":\"45.6\",\"data\":[\"a\",\"b\",\"c\"]}";

        Aoo aoo = JSON.parseObject(json, Aoo.class);
        System.out.println(aoo.getData());


        List<String> data = JSONArray.parseArray(aoo.getData(), String.class);
        System.out.println(data.get(0));

    }


    @Data
    static class Aoo {
        private String name;
        private BigDecimal age;
        private String data;
    }

}

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author qidi
 * @date 2019-04-09 19:36
 */
public class JsonParseDemo {
    public static void main(String[] args) {
        String json = "{\"name\":\"ma\",\"age\":\"5.58\"}";

        Aoo aoo = JSON.parseObject(json, Aoo.class);
        System.out.println(aoo.getAge());

    }

    @Data
    static class Aoo {
        private String name;
        private BigDecimal age;
    }

}

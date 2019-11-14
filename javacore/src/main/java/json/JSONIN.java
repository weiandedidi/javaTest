package json;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * json测试null字段打印
 *
 * @author qidi
 * @date 2019-11-14 20:19
 */
@Data
public class JSONIN {

    private String code;
    private String name;

    public static void main(String[] args) {
        JSONIN jsonin = new JSONIN();
        jsonin.setCode("12312");
        System.out.println(JSON.toJSONString(jsonin));
    }
}

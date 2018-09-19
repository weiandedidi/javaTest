package json;

import com.alibaba.fastjson.JSON;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/9/19
 * Time: 下午2:13
 */
public class TestAo {
    public static void main(String[] args) {
        Bo bo = new Bo();
        bo.setBo("abd");
        Ao ao = new Ao();
        ao.setName("ao");
        ao.setAge("18");
        ao.setBo(bo);
        System.out.println(JSON.toJSONString(ao));
        String xx = "{\"age\":\"18\",\"bo\":{\"bo\":\"abd\"},\"name\":\"ao\"}";
        Ao aoXX = JSON.parseObject(xx, Ao.class);
        System.out.println(aoXX.getName());
    }
}

import com.alibaba.fastjson.JSON;

/**
 * @author qidi
 * @date 2019-06-20 20:07
 */
public class JSONTest {
    public static void main(String[] args) {
        String x = "[{\"count\": \"5.0000\", \"warehouseId\": \"1000006\", \"containerId\": \"35287\", \"skuId\": \"2045\", \"tenantId\": \"1000012\", \"taskId\": \"100925\"}, {\"count\": \"3.0000\", \"warehouseId\": \"1000006\", \"containerId\": \"35296\", \"skuId\": \"2045\", \"tenantId\": \"1000012\", \"taskId\": \"100925\"}, {\"count\": \"4.0000\", \"warehouseId\": \"1000006\", \"containerId\": \"35288\", \"skuId\": \"2045\", \"tenantId\": \"1000012\", \"taskId\": \"100925\"}, {\"count\": \"2.0000\", \"warehouseId\": \"1000006\", \"containerId\": \"35057\", \"skuId\": \"2061\", \"tenantId\": \"1000012\", \"taskId\": \"100927\"}, {\"count\": \"1.0000\", \"warehouseId\": \"1000006\", \"containerId\": \"35057\", \"skuId\": \"2061\", \"tenantId\": \"1000012\", \"taskId\": \"100928\"}, {\"count\": \"1.0000\", \"warehouseId\": \"1000006\", \"containerId\": \"35057\", \"skuId\": \"2061\", \"tenantId\": \"1000012\", \"taskId\": \"100929\"}]\n";

        System.out.println(JSON.toJSONString(x));
    }
}

package clazz;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maqidi
 * @date 2020/8/3 下午9:11
 */
public enum OrderStatus {
    UN_KNOWN(-1, "未知"),
    NORMAL(1, "正常线上推送"),
    MOCK(2, "下单模拟");

    OrderStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    Integer code;

    String message;

    private static Map<Integer, OrderStatus> map = new HashMap<Integer, OrderStatus>(){{
        for (OrderStatus entry : OrderStatus.values()) {
            put(entry.code, entry);
        }
    }};

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static OrderStatus getTypeByValue(Integer value) {
        OrderStatus orderSource = map.get(value);
        return orderSource == null ? OrderStatus.UN_KNOWN : orderSource;
    }
}

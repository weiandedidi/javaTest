package json;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author zhangjunbo02
 */
@Data
public class Head {

    private String type;

    private String message;

    @JSONField(name = "request_id")
    private Integer requestId;

    @JSONField(name = "status_code")
    private Integer statusCode;

    private String version = "1.0";
    /**
     * 供应商
     */
    private String vendor;
    /**
     * client的系统
     */
    private String model;
}

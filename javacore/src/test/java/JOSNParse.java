import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qidi
 * @date 2019-08-08 21:10
 */
public class JOSNParse {

    public static void main(String[] args) {
        String json = "{\"body\":{\"code\":\"0\",\"data\":\"0\",\"message\":\"success\",\"reqCode\":\"16C7147F60311SE\"},\"head\":{\"interfaceName\":\"doCharge\",\"model\":\"uwms\",\"request_id\":\"16C7147F60311SE\",\"serialNo\":\"hk01\",\"type\":\"response\",\"vendor\":\"meituan\",\"version\":\"2.2.3\"}}";
        AgvCommonReportDto dto = JSON.parseObject(json, AgvCommonReportDto.class);

        System.out.println(dto.getBody());


    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class AgvCommonBody {
        /**
         * 状态码
         */
        private String code;
        /**
         * 消息
         */
        private String message;
        /**
         * 数据
         */
        private String data;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class AgvCommonReportDto {
        Head head;
        AgvCommonBody body;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Head {
        private String type;
        /**
         * message 方法名，由于驭金的历史约定问题，这个字段先保留 FIXME
         */
        private String message;

        private String version;
        /**
         * 接口名字
         */
        private String interfaceName;
        /**
         * 供应商
         */
        private String vendor;
        /**
         * client的系统
         */
        private String model;
        /**
         * 系统的序列号
         */
        private String serialNo;
    }




}

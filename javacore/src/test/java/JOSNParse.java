import com.alibaba.fastjson.JSON;

/**
 * @author qidi
 * @date 2019-08-08 21:10
 */
public class JOSNParse {

    public static void main(String[] args) {
        String json = "{\"body\":{\"code\":\"0\",\"data\":\"0\",\"message\":\"success\",\"reqCode\":\"16C73D7FBA21EEQ\"},\"head\":{\"interfaceName\":\"chargeDone\",\"model\":\"uwms\",\"request_id\":\"16C73D7FBA21EEQ\",\"serialNo\":\"hk01\",\"type\":\"response\",\"vendor\":\"meituan\",\"version\":\"2.2.3\"}}";
        AgvCommonReportDto dto = JSON.parseObject(json, AgvCommonReportDto.class);


        System.out.println(dto.getBody().getData());


    }


    static class Body {
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
        private Object data;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }



    static class AgvCommonReportDto {
        Head head;
        Body body;

        public Head getHead() {
            return head;
        }

        public void setHead(Head head) {
            this.head = head;
        }

        public Body getBody() {
            return body;
        }

        public void setBody(Body body) {
            this.body = body;
        }
    }

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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getInterfaceName() {
            return interfaceName;
        }

        public void setInterfaceName(String interfaceName) {
            this.interfaceName = interfaceName;
        }

        public String getVendor() {
            return vendor;
        }

        public void setVendor(String vendor) {
            this.vendor = vendor;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getSerialNo() {
            return serialNo;
        }

        public void setSerialNo(String serialNo) {
            this.serialNo = serialNo;
        }
    }


}

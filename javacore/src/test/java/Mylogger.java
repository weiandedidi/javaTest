import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 测试日志的错误打印
 *
 * @author qidi
 * @date 2019-06-10 10:19
 */
@Slf4j
public class Mylogger {


    public static void main(String[] args) {
        List<Aoo> aoos = Lists.newArrayList();
        aoos.add(null);

        try {
            System.out.println(aoos.get(0).getAge());
        } catch (Exception e) {
            log.error("这是错误, e=", e);
        }
    }

    @AllArgsConstructor
    @Data
    class Aoo {
        private String name;
        private Integer age;
    }
}

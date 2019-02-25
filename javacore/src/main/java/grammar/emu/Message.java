package grammar.emu;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author qidi
 * @date 2019-02-25 11:34
 */
@Data
@AllArgsConstructor
public class Message {
    /**
     * 信息
     */
    private String msg;
    /**
     * 数据
     */
    private String date;
}

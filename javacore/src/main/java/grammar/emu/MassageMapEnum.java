package grammar.emu;

/**
 * map映射类型枚举
 *
 * @author qidi
 * @date 2019-02-25 11:33
 */
public enum MassageMapEnum {
    SUCESS(0, new Message("sucess", "0")), FAIL(1, new Message("fail", "1"));

    private int code;
    private Message message;

    MassageMapEnum(int code, Message message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public Message getMessage() {
        return message;
    }}

package com.qidi.bootdemo2.nio.live;

import lombok.Data;

/**
 * Created by RoyDeng on 17/11/23.
 */
@Data
public class LiveMessage {

    static final byte TYPE_HEART = 1;
    static final byte TYPE_MESSAGE = 2;

    private byte type;
    private int length;
    private String content;

    @Override
    public String toString() {
        return "LiveMessage{" +
                "type=" + type +
                ", length=" + length +
                '}';
    }
}

package byteDemo;

import java.util.Arrays;

/**
 * 如果说 byte 转 int 要考虑符号位，那么byte数组呢（4个byte转换1个int）
 * <p>
 * 这时，我们要保持二进制的表示，什么意思呢
 * <p>
 * <p>
 * 4个byte: -1 2 3 4
 * -1: 11111111
 * 2 : 00000010
 * 3 : 00000011
 * 4 : 00000100
 * <p>
 * User: qidi
 * Date: 2018/8/20
 * Time: 下午2:03
 */
public class Byte2Int {
    public static void main(String[] args) {
        byte[] bytes = {-1, 2, 3, 4};
        int xxx = bytes2Int(bytes);
        System.out.println(Integer.toBinaryString(xxx));

        byte[] new2 = int2Bytes(xxx);
        for (int i = 0; i < new2.length; i++) {

            System.out.println(new2[i]);
        }
    }


    public static int bytes2Int(byte[] bytes) {
        int value = 0;
        value = ((bytes[0] & 0xff) << 24) |
                ((bytes[1] & 0xff) << 16) |
                ((bytes[2] & 0xff) << 8) |
                (bytes[3] & 0xff);
        return value;
    }


    public static byte[] int2Bytes(int value) {
        byte[] src = new byte[4];
        src[0] = (byte) ((value >> 24) & 0xFF);
        src[1] = (byte) ((value >> 16) & 0xFF);
        src[2] = (byte) ((value >> 8) & 0xFF);
        src[3] = (byte) (value & 0xFF);
        return src;
    }
}

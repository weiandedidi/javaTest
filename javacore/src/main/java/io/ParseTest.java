package io;


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * java IO 如果使用同一个byte[] 读取文件，如果不是最后的结尾，byte中有上次的参与，
 * 建议循环中新建byte
 * User: qidi
 * Date: 2018/9/10
 * Time: 下午7:51
 */
public class ParseTest {
    public static void main(String[] args) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("/Users/qidi/Code/me/javaStu/javacore/src/main/java/io/data.file"));

        byte[] body = new byte[5];
        int length = dataInputStream.read(body);
        String message = null;
        if (-1 == length) {
            return;
        }
//        message = new String(body, "utf-8");
        //防重复读取
        message = new String(body, 0, length, "utf-8");
        StringBuilder builder = new StringBuilder();

        if (message.startsWith("ABD")) {
            builder.append(message);
            System.out.println(message);
            //读到结尾DBA
            while (length != -1) {
//                body = new byte[5];
                length = dataInputStream.read(body);
                if (-1 != length) {
//                    message = new String(body, "utf-8");
                    //防重复读取
                    message = new String(body, 0, length, "utf-8");
                    System.out.println(message);
                    builder.append(message);
                }
                if (message.trim().endsWith("DBA")) {
                    break;
                }
            }

        }
        System.out.println(builder.toString());
    }
}

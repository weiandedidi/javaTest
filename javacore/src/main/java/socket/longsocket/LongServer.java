package socket.longsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/8/10
 * Time: 下午5:56
 */
public class LongServer {
    static int port = 11002;

    public static void Connect() {
        System.out.println("等待客户端连接。。。");
        PrintWriter writer = null;
        BufferedReader reader = null;
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(port);
            socket = server.accept();
            System.out.println(socket.getInetAddress() + "已成功连接到此台服务器上。");
            writer = new PrintWriter(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //先读取在写入
            StringBuilder builder = new StringBuilder();
            String result = builder.toString();
            String line;
            while ((line = reader.readLine()) != null) {
//                builder = builder.append(line);
                StringBuilder back = new StringBuilder();
                if (line.startsWith("ABD") && line.endsWith("DBA")) {
                    Long time = System.currentTimeMillis() / 1000;
                    back.append(33098).append(",")
                            .append(1).append(",")
                            .append(time).append("\n");

                } else {
                    back.append(33098).append("\n");
                }

                System.out.println("发送数据：   " + back.toString());
                writer.write(back.toString());
                writer.flush();
                System.out.println("client端返回=========" + line + "===");
                //一秒发包一次
                Thread.sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != reader) reader.close();
                if (null != writer) writer.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connect();
    }
}

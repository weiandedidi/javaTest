package socket.shotsocket;

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
public class OnceServer {
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
            line = reader.readLine();
            System.out.println("收到数据：   " + line);
            writer.write("发送数据到客户端，客户端收到");
            writer.flush();

        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                if (null != reader) reader.close();
                if (null != writer) writer.close();
                //用完关闭socket 不然一直连着
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

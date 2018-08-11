package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket痛惜避免使用BufferedReader.readline()如果不是文章尾部，或者/n是会导致阻塞的
 * User: qidi
 * Date: 2018/8/6
 * Time: 下午4:04
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        //监听端口
        int port = 11002;
        // server将一直等待连接的到来
        ServerSocket server = new ServerSocket(port);
        System.out.println("服务端开启服务...");
        Socket socket = server.accept();
        System.out.println("客户端开始连接..." + socket.getInetAddress());
        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
            sb.append(new String(bytes, 0, len, "UTF-8"));
        }
        System.out.println("get message from client: " + sb);
        inputStream.close();
        socket.close();
        server.close();

    }
}

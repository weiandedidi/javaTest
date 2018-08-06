package socket;

import java.io.*;
import java.net.Socket;

/**
 * abd视频客户端
 * User: qidi
 * Date: 2018/8/6
 * Time: 下午2:59
 */
public class AbdClient {
    public static void main(String[] args) throws IOException {
        //创建Socket对象
        //    固定ip
        String ip = "192.168.1.100";
        Socket socket = new Socket(ip, 11001);
        //构建IOs
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));//将输出流包装成打印流
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));


            //向服务器端发送一条消息
//            bw.write("测试客户端和服务器通信，服务器接收到消息返回到客户端\n");
//            bw.flush();
            //读取服务器返回的消息
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = br.readLine();
            String mess = line;
            System.out.println("服务器：" + mess);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

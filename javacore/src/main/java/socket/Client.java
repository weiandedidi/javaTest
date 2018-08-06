package socket;

import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/8/6
 * Time: 下午4:06
 */
public class Client {
    public static void main(String[] args) {
        //构建IO
        try {

            Socket s = new Socket("127.0.0.1", 8888);
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            //向服务器端发送一条消息json数据
            bw.write("{\"name\":\"qidi\",\"age\":18}\n");
            bw.flush();

            //读取服务器返回的消息
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String mess = br.readLine();
            System.out.println("服务器：" + mess);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

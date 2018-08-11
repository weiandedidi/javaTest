package socket.longsocket;

import java.io.*;
import java.net.Socket;

/**
 * abd视频客户端
 * User: qidi
 * Date: 2018/8/6
 * Time: 下午2:59
 */
public class LongClient {
    public static void main(String[] args) throws IOException {
        //创建Socket对象
        //    固定ip
        String ip = "localhost";
        Socket socket = new Socket(ip, 11002);
        //构建IOs
        BufferedWriter writer = null;
        BufferedReader reader = null;
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            writer = new BufferedWriter(new OutputStreamWriter(os));//将输出流包装成打印流
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            //向服务器端发送一条消息
            writer.write("测试客户端和服务器通信，服务器接收到消息返回到客户端\r\n");
            writer.write("\r\n");
            writer.flush();
            //读取服务器返回的消息
            String line = null;
            StringBuilder builder = new StringBuilder();

            int count = 0;
            while ((line = reader.readLine()) != null) {
                writer.write("客户端:"+System.currentTimeMillis()+"\n");
                System.out.println("server saying: "+line);
                writer.flush();

                count++;
                if (count > 100) {
                    break;
                }
            }


  /*        byte[] buf = new byte[1024];
            int len = 0;
            while ((len=is.read(buf))!=-1){
                writer.write("客户端:"+System.currentTimeMillis()+"\n");
                System.out.println("client saying: "+new String(buf,0,len));
                writer.flush();
            }
            String mess = builder.toString();
            System.out.println("服务器：" + mess);*/


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != writer) writer.close();
            if (null != reader) reader.close();
            socket.close();
        }
    }


}

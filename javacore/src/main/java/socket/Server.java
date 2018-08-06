package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/8/6
 * Time: 下午7:14
 */
public class Server {
    /**
     * 监听端口11001
     */
    public static final int PORT = 11001;

    public static void main(String[] args) {
        System.out.println("服务器启动》》》》》》");
        Server server = new Server();
        server.init();
    }

    private void init() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                //一旦有堵塞，表示服务器与客户端获得了连接
                Socket client = serverSocket.accept();
                System.out.println("有客户端接进来");
                new HandlerThread(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO 使用高可用的线程池
    private class HandlerThread implements Runnable {
        private Socket socket;

        public HandlerThread(Socket socket) {
            this.socket = socket;
            new Thread(this).start();
        }

        @Override
        public void run() {
            //IO
            BufferedReader reader = null;
            PrintWriter printWriter = null;
            try {
                InputStream in = socket.getInputStream();
                OutputStream os = socket.getOutputStream();

                reader = new BufferedReader(new InputStreamReader(in));
                printWriter = new PrintWriter(os);
                String data = reader.readLine();
                System.out.println(data);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != reader) reader.close();
                    if (null != printWriter) printWriter.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }

}

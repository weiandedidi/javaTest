package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/8/7
 * Time: 下午4:39
 */
public class ABDServer {
    /**
     * TODO 可配置的监听端口11001
     */
    public static final int PORT = 11001;
    //维护一个线程池
    private ExecutorService executorPool;
    private Integer FIX_THREAD_SIZE = 5;


    public static void main(String[] args) throws IOException {

        System.out.println("服务器启动》》》》》》");
        ABDServer ABDServer = new ABDServer();
        ServerSocket serverSocket = new ServerSocket(ABDServer.PORT);
        ABDServer.init(serverSocket);
    }

    private void init(ServerSocket serverSocket) {
        try {
            executorPool = Executors.newFixedThreadPool(FIX_THREAD_SIZE);
            while (true) {
                //一旦有堵塞，表示服务器与客户端获得了连接
                Socket client = serverSocket.accept();
                System.out.println("有客户端接进来");
                executorPool.execute(new HandlerThread(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TODO 使用高可用的线程池
    private class HandlerThread implements Runnable {
        Socket socket = null;

        public HandlerThread(Socket client) {
            this.socket = client;
        }

        public void run() {
            //IO
            BufferedReader reader = null;
            PrintWriter printWriter = null;
            StringBuilder builder = new StringBuilder();
            try {
                InputStream in = socket.getInputStream();
                OutputStream os = socket.getOutputStream();

                reader = new BufferedReader(new InputStreamReader(in));
                printWriter = new PrintWriter(os);
                String line;

                while ((line = reader.readLine()) != null) {
                    builder = builder.append(line);
                }
                System.out.println("from client..." + socket.getInetAddress() + " 当前线程：" + Thread.currentThread().getName());
                System.out.println(builder.toString());
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

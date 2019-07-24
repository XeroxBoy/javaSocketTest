package ServerSocket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class socketServer {
    public static void main(String[] args) throws Exception {
        // 监听指定的端口
        int port = 55533;
        try {
            ServerSocket server = new ServerSocket(port);
            int count = 0;
            while (true) {
                // server将一直等待连接的到来
                System.out.println("server将一直等待连接的到来");
                //如果使用多线程，那就需要线程池，防止并发过高时创建过多线程耗尽资源
                Socket socket = server.accept();
                InetAddress inetAddress = socket.getInetAddress();
                serverThread thread = new serverThread(socket, inetAddress);
                thread.run();
                count++;
                System.out.println("现已有" + count + "个客户端进行了连接");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

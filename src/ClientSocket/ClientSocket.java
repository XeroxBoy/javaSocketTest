package ClientSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientSocket {
    public static void main(String args[]) throws Exception {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 55533;
        // 与服务端建立连接
        Socket socket = new Socket(host, port);
        // 建立连接后获得输出流
        OutputStream outputStream = null;
        InputStream inputStream = null;
                try {
                    outputStream = socket.getOutputStream();
                    outputStream.write(("我是客户端" + Math.random() * 100 + "号").getBytes(StandardCharsets.UTF_8));
                    socket.shutdownOutput();
                    inputStream = socket.getInputStream();
                    byte[] bytes = new byte[1024];
                    StringBuilder sb = new StringBuilder();
                    int len;
                    while ((len = inputStream.read(bytes)) != -1) {
                        sb.append(new String(bytes, 0, len, StandardCharsets.UTF_8));
                    }
                    System.out.println("客户端收到了" + sb);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (socket != null) {
                        socket.close();
                    }
                }
    }
}





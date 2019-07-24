package ClientSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientSocket {
    public static void main(String args[]) throws Exception {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 55533;
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        // 与服务端建立连接
        Socket socket = new Socket(host, port);
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();

            Runnable runnable = () -> {
                String message = "你好  yiwangzhibujian";
                try {
                    outputStream.write(message.getBytes(StandardCharsets.UTF_8));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };

        threadPool.submit(runnable);
            outputStream.close();
            socket.close();

        //通过shutdownOutput高速服务器已经发送完数据，后续只能接受数据
//        socket.shutdownOutput();

//        InputStream inputStream = socket.getInputStream();
//        byte[] bytes = new byte[1024];
//        int len;
//        StringBuilder sb = new StringBuilder();
//        while ((len = inputStream.read(bytes)) != -1) {
//            //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
//            sb.append(new String(bytes, 0, len, StandardCharsets.UTF_8));
//        }
//        System.out.println("get message from server: " + sb);
//        inputStream.close();
        }
    }




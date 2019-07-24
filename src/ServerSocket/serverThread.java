package ServerSocket;

import java.net.InetAddress;
import java.net.Socket;

public class serverThread implements Runnable{
    Socket socket = null;
    InetAddress inetAddress = null;

    public serverThread(Socket socket, InetAddress inetAddress) {
        this.socket = socket;
        this.inetAddress = inetAddress;
    }

    @Override
    public void run() {

    }
}


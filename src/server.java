
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    static int i;
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5678);
        while(true){
        Socket socket = server.accept();

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Hello Client,I get the message.".getBytes("UTF-8"));
        outputStream.close();
        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = in.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len, "UTF-8"));
        }
        System.out.println("get message from client: " + sb);
        in.close();
        socket.close();
    }


    }
}

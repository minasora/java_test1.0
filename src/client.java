import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class client {
    static Socket client;
    public static void main(String[] args) throws IOException
    {
        client = new Socket(InetAddress.getLocalHost(),5678);
        InputStream inputStream = client.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();


        while ((len = inputStream.read(bytes)) != -1) {
            //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
            sb.append(new String(bytes, 0, len,"UTF-8"));
        }
        System.out.println("get message from server: " +sb);
        String str = "1234";
        client.getOutputStream().write(str.getBytes("UTF-8"));

        inputStream.close();
        client.close();

    }
}

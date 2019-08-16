import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class client {
    static Socket client;
    public static void main(String[] args) throws IOException
    {
        client = new Socket(InetAddress.getLocalHost(),5678);
        DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
        String str = "123";
        dataOutputStream.writeUTF(str);

    }
}

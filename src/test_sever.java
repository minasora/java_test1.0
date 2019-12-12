import com.mysql.fabric.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class test_sever {
    public static ServerSocket Newsocket() throws IOException {
        String str;
        ServerSocket client = new ServerSocket(1111);
        return client;
    }
    private void receieveFile(String filename,ServerSocket server) {
        while (true) {
            try {
                Socket socket = null;

                socket = server.accept();


                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(filename));

                byte[] buf = new byte[1027 * 9];
                int len = 0;

                while ((len = dataInputStream.read(buf)) != -1) {
                    dataOutputStream.write(buf, 0, len);
                }
                dataOutputStream.flush();
                dataInputStream.close();

            } catch (IOException e) {
                
                e.printStackTrace();
            }

        }

    }

}

import java.io.*;
import java.net.Socket;

public class test_client {
    public static Socket Newsocket() throws IOException {
        String str;
        Socket client = new Socket("211.159.161.72", 5678);
        DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
        str = dataInputStream.readUTF();
        return client;
    }
    private void sendFile(String filePath,Socket client) throws IOException
    {
        File file = new File(filePath);
        while (true) {


                DataInputStream input = new DataInputStream(new FileInputStream(filePath));
                DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
                byte[] buf = new byte[1024 * 9];
                int len = 0;
                while ((len = input.read(buf)) != -1) {
                    outputStream.write(buf, 0, len);
                }
                outputStream.flush();
                System.out.println("文件上传结束，，，，");

                input.close();
                outputStream.close();
            }

        }

    }



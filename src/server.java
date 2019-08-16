
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class server {
    static int i =0;
    public static List<Socket> socketList = new ArrayList<Socket>();

    public static void deal(Socket client)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String str;
                    DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
                    DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
                    while(true)
                    {
                        str = dataInputStream.readUTF();
                        for(Socket item : socketList)
                        {
                            if(item.equals(this))
                            {
                                continue;
                            }
                            DataOutputStream OutputStream = new DataOutputStream(item.getOutputStream());
                            OutputStream.writeUTF(str);


                        }

                    }
                }
                catch(IOException t)
                {

                }

            }
        }).start();
    }
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5678);
        while(true) {

            Socket socket = server.accept();
            socketList.add(socket);
            deal(socket);
        }
    }


    }

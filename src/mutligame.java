import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class mutligame{
    static int chest[][] = new int [16][16];
    static int x;
    static int y;
    static Socket client;
    static int BlackorWhite =2;
    public static void Newsocket() throws IOException
    {
        client = new Socket(InetAddress.getLocalHost(),5678);
    }
    public static void input(JPanel game) throws IOException
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                            while(true) {
                                DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
                                DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
                                String in = dataInputStream.readUTF();
                                System.out.println("1321321");
                                String[] temp;
                                String delimeter = "-";  // 指定分割字符
                                temp = in.split(delimeter);
                                chest[Integer.valueOf(temp[0])][Integer.valueOf(temp[1])] = Integer.valueOf(temp[2]);
                                game.update(game.getGraphics());
                            }
                    }
                catch(IOException s)
                {

                }
            }
        }).start();




    }

    public static void client(int tmp1,int tmp2,int BlackorWhite) throws IOException
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());
                    DataInputStream dataInputStream = new DataInputStream(client.getInputStream());

                    String str = String.valueOf(tmp1) + "-" + String.valueOf(tmp2) + "-" + String.valueOf(BlackorWhite);
                    dataOutputStream.writeUTF(str);
                } catch (IOException b) {

                }
            }
        }).start();


    }
    public static void Multiselect(JFrame jf,JPanel jp) throws IOException{
        class gameJpanel extends JPanel
        {
            public void paint(Graphics g)
            {
                g.clipRect(0,0,800,800);
                BufferedImage bi = new BufferedImage(700,500,BufferedImage.TYPE_INT_RGB);
                try {
                    Image bg = ImageIO.read(new File("background3.jpg"));
                    g.drawImage(bg,1,20,this);
                }
                catch(IOException e)
                {

                }

                for(int i = 0;i<=15;i++)
                    for(int j = 0;j<=15;j++) {
                        if (chest[i][j] == 1) {
                            g.setColor(Color.black);
                            g.fillOval(23 + 29 * i, 45 + 29 * j, 20, 20);
                            for(int p=0;p<=15;p++)
                                for(int q =0;q<=15;q++){
                                    String a = String.valueOf(algorithm.result[p][q]);
                                    g.setColor(Color.black);
                                    g.drawString(a, 23 + 29 * p, 45 + 29 * q);
                                }
                        }
                        if (chest[i][j] == 2)
                        {
                            g.setColor(Color.WHITE);
                            g.fillOval(23 + 29 * i, 45 + 29 * j, 20, 20);
                            for(int p=0;p<=15;p++)
                                for(int q =0;q<=15;q++){
                                    String a = String.valueOf(algorithm.result[p][q]);
                                    g.setColor(Color.black);
                                    g.drawString(a, 23 + 29 * p, 45 + 29 * q);
                                }
                        }
                    }
            }

        }
        gameJpanel gameJpanel = new gameJpanel();
        jf.add(gameJpanel);
        Newsocket();
        input(gameJpanel);

        gameJpanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x=e.getX();
                y=e.getY();
                if(x>20 && y>40 &&x<520 && y<540) {
                    int tmp1 = (x - 23) / 29;
                    int tmp2 = (y - 45) / 29;
                    singlegame.lastx = tmp1;
                    singlegame.lasty = tmp2;
                        if (chest[tmp1][tmp2] == 0) {
                            chest[tmp1][tmp2] = BlackorWhite;
                            try {
                                client(tmp1, tmp2, BlackorWhite);
                            } catch (IOException t)
                            {

                            }
                            gameJpanel.update(gameJpanel.getGraphics());
                        }

                }

                }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

}}


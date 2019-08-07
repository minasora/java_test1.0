import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class singlegame {
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
                    }
                    if (chest[i][j] == 2)
                    {
                        g.setColor(Color.WHITE);
                        g.fillOval(23 + 29 * i, 45 + 29 * j, 20, 20);
                    }
                }
        }

    }
    static int lastx;
    static int lasty;
    static int x;
    static int y;
    static int BlackorWhite = 2; //1 时为black，2时为white
    static int chest[][]  = new int[200][200];
    static void restart()
    {
        for(int i=0;i<=20;i++)
            for(int j=0;j<=29;j++)
                chest[i][j] =0;
        BlackorWhite = 2;
    }
    protected  void modeSelect(JFrame frame,JPanel panel){
        restart();
        gameJpanel jp = new gameJpanel();
        jp.setLayout(null);
        jp.setVisible(true);
        frame.add(jp);
        jp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                        singlegame.x=e.getX();
                        singlegame.y=e.getY();
                        if(singlegame.x>20 && singlegame.y>40 &&singlegame.x<520 && singlegame.y<540) {
                            int tmp1 = (singlegame.x - 23) / 29;
                            int tmp2 = (singlegame.y - 45) / 29;
                            singlegame.lastx = tmp1;
                            singlegame.lasty = tmp2;
                            if (chest[tmp1][tmp2] == 0) {
                                System.out.println(BlackorWhite);
                                if (BlackorWhite == 2) {
                                    chest[tmp1][tmp2] = 2;
                                    if(algorithm.Checkwin(chest,tmp1,tmp2,BlackorWhite))
                                    {
                                        if(algorithm.Checkwin(chest,tmp1,tmp2,BlackorWhite))
                                        {
                                            JOptionPane.showMessageDialog(jp, "白方胜利", "游戏结束",JOptionPane.WARNING_MESSAGE);
                                        }
                                    }
                                    BlackorWhite = 1;
                                } else {
                                    chest[tmp1][tmp2] = 1;
                                    if(algorithm.Checkwin(chest,tmp1,tmp2,BlackorWhite))
                                    {
                                        JOptionPane.showMessageDialog(jp, "黑方胜利", "游戏结束",JOptionPane.WARNING_MESSAGE);
                                    }
                                    BlackorWhite = 2;
                                }

                            }
                            jp.update(jp.getGraphics());
                        }
                         if(singlegame.x>537 && singlegame.x<665) {
                             if (singlegame.y > 110 && singlegame.y < 124) {
                                 restart();
                                 frame.repaint();
                             }
                             if (singlegame.y > 181 && singlegame.y < 195) {
                                 chest[lastx][lasty] = 0;
                                 if(BlackorWhite == 1)BlackorWhite =2;
                                 else BlackorWhite= 1;
                                 frame.repaint();
                             }
                             if(singlegame.y > 244 && singlegame.y <257){
                                 frame.remove(jp);
                                 panel.setVisible(true);
                                 frame.repaint();
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

        frame.setVisible(true);
        frame.repaint();

    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class singlegame {
    protected static void modeSelect(JFrame frame){

        JPanel jp = new JPanel();
        jp.setLayout(null);
        ImageIcon imageicon = new ImageIcon("background3.jpg");
        JLabel lb = new JLabel(imageicon);
        lb.setBounds(20,20,500,500);
        jp.add(lb);
        JButton userButton1 = new JButton("设定难度");
        JButton userButton2 = new JButton("悔棋");
        JButton userButton3 = new JButton("回到主菜单");
        userButton1.setBounds(550,100,200,50);
        userButton2.setBounds(550,150,200,50);
        userButton3.setBounds(550,200,200,50);
        jp.add(userButton1);
        jp.add(userButton2);
        jp.add(userButton3);
        userButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(jp);

                frame.repaint();

            }
        });
        frame.add(jp);
        frame.setVisible(true);
        frame.repaint();
    }
}

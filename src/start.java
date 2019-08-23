//绘制开始界面
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class start {
    JPanel panel = new JPanel();
    protected  void createAndshowGUI(){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        //风格设定
        JFrame frame = new JFrame("fivesonchest");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        //框架设定

        frame.add(panel);
        changePanel(panel,frame);
        //面板设定

        frame.setVisible(true);
    }
    protected void changePanel(JPanel panel,JFrame frame)
    {

        panel.setLayout(null);//设定布局

        ImageIcon imageicon = new ImageIcon("background.jpg");
        JLabel lb = new JLabel(imageicon);
        lb.setBounds(0,0,frame.getWidth(),frame.getHeight());
        frame.getLayeredPane().add(lb,new Integer(Integer.MIN_VALUE));
        JPanel j = (JPanel)frame.getContentPane();
        j.setOpaque(false);


        JButton userButton1 = new JButton("单人游戏");
        JButton userButton2 = new JButton("多人游戏");
        JButton userButton4 = new JButton("游戏设置");
        JButton userButton3 = new JButton("退出游戏");
        userButton1.setFont(new Font("微软雅黑", Font.BOLD, 25));
        userButton2.setFont(new Font("微软雅黑", Font.BOLD, 25));
        userButton3.setFont(new Font("微软雅黑", Font.BOLD, 25));
        userButton4.setFont(new Font("微软雅黑", Font.BOLD, 25));
        userButton1.setBounds(250,100,300,100);
        userButton2.setBounds(250,200,300,100);
        userButton4.setBounds(250,300,300,100);
        userButton3.setBounds(250,400,300,100);
        userButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                singlegame game = new singlegame();
                game.modeSelect(frame,panel);
            }
        });
        userButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitgame.exit();
            }
        });
        userButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                menu.select_menu(frame,panel);

            }
        });
        userButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                mutligame game = new mutligame();
                try {
                    mutligame.Can_restart = false;
                    mutligame.Multiselect(frame, panel);
                }
                catch (IOException a)
                {

                }
            }
        });

        panel.add(userButton1);
        panel.add(userButton2);
        panel.add(userButton3);
        panel.add(userButton4);

        panel.setOpaque(false);
    }

}

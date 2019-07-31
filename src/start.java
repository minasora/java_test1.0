//绘制开始界面
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class start {
    protected static void createAndshowGUI(){
        try {

            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");//Nimbus风格，jdk6 update10版本以后的才会出现
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//当前系统风格
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");//Motif风格，是蓝黑
            //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());//跨平台的Java风格
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");//windows风格
            //UIManager.setLookAndFeel("javax.swing.plaf.windows.WindowsLookAndFeel");//windows风格
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");//java风格
            //UIManager.setLookAndFeel("com.apple.mrj.swing.MacLookAndFeel");//待考察，

        } catch (Exception e) {
            e.printStackTrace();
        }
        //风格设定
        JFrame frame = new JFrame("fivesonchest");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        //框架设定
        JPanel panel = new JPanel();
        frame.add(panel);
        changePanel(panel,frame);
        //面板设定

        frame.setVisible(true);
    }
    private  static void changePanel(JPanel panel,JFrame frame)
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
        JButton userButton3 = new JButton("退出游戏");
        userButton1.setFont(new Font("微软雅黑", Font.BOLD, 25));
        userButton2.setFont(new Font("微软雅黑", Font.BOLD, 25));
        userButton3.setFont(new Font("微软雅黑", Font.BOLD, 25));
        userButton1.setBounds(250,100,300,100);
        userButton2.setBounds(250,200,300,100);
        userButton3.setBounds(250,300,300,100);
        userButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panel);
                singlegame.modeSelect(frame);
            }
        });
        userButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitgame.exit();
            }
        });
        panel.add(userButton1);
        panel.add(userButton2);
        panel.add(userButton3);
        panel.setOpaque(false);
    }

}

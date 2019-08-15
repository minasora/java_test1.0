import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu {
    static int If_ai = 0;
    static int If_time =0;
    protected static void select_menu(JFrame jFrame,JPanel panel)
    {
        JPanel jp = new JPanel();
        JLabel lb1 = new JLabel("单人游戏设置");
        JButton button1 = new JButton("回主菜单");
        button1.setBounds(500,300,200,100);
        button1.setFont(new Font("微软雅黑",Font.BOLD,23));
        JRadioButton radioButton3 = new JRadioButton("时间显示");

        jp.setLayout(null);
        JRadioButton radioBtn01 = new JRadioButton("本地双人");
        radioBtn01.setBounds(250,100,300,50);
        radioBtn01.setFont(new Font("微软雅黑",Font.BOLD,25));
        lb1.setBounds(100,50,300,50);
        lb1.setFont(new Font("微软雅黑",Font.BOLD,25));
        JRadioButton radioBtn02 = new JRadioButton("ai对战");
        radioBtn02.setBounds(250,150,300,50);
        radioBtn02.setFont(new Font("微软雅黑",Font.BOLD,25));
        radioButton3.setBounds(250,200,300,50);
        radioButton3.setFont(new Font("微软雅黑",Font.BOLD,25));
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(radioBtn01);
        btnGroup.add(radioBtn02);
        radioBtn01.setSelected(true);
        jp.add(radioBtn01);
        jp.add(radioBtn02);
        jFrame.add(jp);
        jp.add(lb1);
        jp.add(button1);
        radioBtn01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                If_ai = 0;
            }
        });
        radioBtn02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                If_ai = 1;
                System.out.println(If_ai);
            }
        });


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.remove(jp);
                jFrame.repaint();
                panel.setVisible(true);

            }
        });

    }
}

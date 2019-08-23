import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login {
    protected static void Login()
    {
        JFrame jf = new JFrame("登录");

        //设置窗体的位置及大小
        jf.setBounds(600, 200, 300, 250);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel jp = new JPanel();
        jp.setLayout(null);
        JButton button1= new JButton("登录");
        JButton button2 = new JButton("注册");
        JLabel lb1 = new JLabel("用户名");
        JLabel lb2 = new JLabel("密 码");
        JTextField username = new JTextField();
        JPasswordField password = new JPasswordField();
        lb1.setBounds(50,10,50,50);
        lb2.setBounds(50,60,50,50);
        username.setBounds(100,25,150,25);
        password.setBounds(100,75,150,25);
        button1.setBounds(50,150,75,50);
        button2.setBounds(175,150,75,50);
        jp.add(lb1);
        jp.add(lb2);
        jp.add(username);
        jp.add(password);
        jp.add(button1);
        jp.add(button2);
        jf.add(jp);
        jp.setVisible(true);
        jf.setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                start ak = new start();
                ak.createAndshowGUI();
            }
        });
    }
}

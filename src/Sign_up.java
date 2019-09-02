import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sign_up {
    protected static void Sign_up(JFrame jf,JPanel jp) {
        JPanel sign_up_panel = new JPanel();
        sign_up_panel.setLayout(null);
        JButton Button1 = new JButton("注册");
        JButton Button2 = new JButton("返回");
        JButton Button3 = new JButton("获取验证码");
        JLabel lb1 = new JLabel("用户名");
        JLabel lb2 = new JLabel("密 码");
        JLabel lb3 = new JLabel("确认密码");
        JLabel lb4 = new JLabel("密保邮箱");
        JLabel lb5 = new JLabel("验证码");
        JTextField username = new JTextField();
        JTextField E_mail = new JTextField();
        JTextField Comfirm = new JTextField();
        JPasswordField pas_comfird = new JPasswordField();
        JPasswordField password = new JPasswordField();
        lb1.setBounds(50,15,50,30);
        lb2.setBounds(50,45,50,30);
        lb3.setBounds(50,75,50,30);
        lb4.setBounds(50,105,50,30);
        lb5.setBounds(50,135,50,30);
        username.setBounds(100,20,150,20);
        password.setBounds(100,50,150,20);
        pas_comfird.setBounds(100,80,150,20);
        E_mail.setBounds(100,110,150,20);
        Comfirm.setBounds(100,140,150,20);
        Button1.setBounds(20,170,60,30);
        Button2.setBounds(100,170,60,30);
        Button3.setBounds(160,170,100,30);
        sign_up_panel.add(lb1);
        sign_up_panel.add(lb2);
        sign_up_panel.add(username);
        sign_up_panel.add(password);
        sign_up_panel.add(lb3);
        sign_up_panel.add(lb4);
        sign_up_panel.add(lb5);
        sign_up_panel.add(E_mail);
        sign_up_panel.add(pas_comfird);
        sign_up_panel.add(Comfirm);
        sign_up_panel.add(Button1);
        sign_up_panel.add(Button2);
        sign_up_panel.add(Button3);
        jf.add(sign_up_panel);
        jf.setVisible(true);
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usr = username.getText();
                String psd = String.valueOf(password.getPassword());
                String psd_con = String.valueOf(pas_comfird.getPassword());

                if (psd.equals(psd_con))
                {
                    if(regex_check.If_mail_legal(usr) && (regex_check.If_psd_legal(psd)))
                    {
                        JOptionPane.showMessageDialog(jp,"请查收邮箱获取验证码");
                        try
                        {
                            testsql.Sing_up(usr,psd);
                        }
                        catch (Exception s)
                        {

                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(jp,"用户名或密码非法，请重新输入");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(jp,"密码前后不一致！");
                }

            }
        });
        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.remove(sign_up_panel);
                jp.setVisible(true);
            }
        });
    }

}


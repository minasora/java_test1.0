import javax.mail.Transport;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class mailtest {
    String to = "1642940680@qq.com";
    String from = "minasora@163.com";
    public static void main(String[] args) throws Exception
    {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol","smtp");
        props.setProperty("mail.host","smtp.163.com");
        props.setProperty("mail.smtp.auth","true");
        //ssl设置
        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        //session
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("minasora@163.com","minasora","UTF-8"));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("minasora@163.com", "用户", "UTF-8"));
        message.setSubject("hello","UTF-8");
        message.setContent("Hello,World","text/html;charset=UTF-8");
        message.setSentDate(new Date());
        //传输对象
        Transport transport = session.getTransport();
        transport.connect("minasora@163.com","Liboxiaoqq11qq");
        transport.sendMessage(message,message.getAllRecipients());
        transport.close();
    }
}

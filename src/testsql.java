import javax.swing.*;
import java.awt.desktop.SystemSleepEvent;
import java.sql.*;

public class testsql {
    static final String JDBC_DRIVER = "jdbc:mysql://localhost:3306/jsp_db?useSSL=false";
    static final String DB_URL = "jdbc:mysql://cdb-31eo6yoc.cd.tencentcdb.com:10028";
    static final String USER = "root";
    static final String PASS = "liboxiaoqq11qq";
    public static Boolean Sign_in(String usr,String psd )throws Exception {//登录函数

        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection(DB_URL, USER,PASS);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from chest;  ");
        System.out.print(rs.getString(1));
        while(rs.next())
        {
            System.out.println(psd);
            if(rs.getString("psd").equals(psd))
            {
                return true;
            }
        }
        return false;
    }
    public static void Sing_up(String usr,String psd) throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(
                "insert into  chest(usr,psd) values ('"+usr+"','"+psd+"')"
        );
    }


}

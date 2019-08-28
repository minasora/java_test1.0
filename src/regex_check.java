import java.util.regex.*;
public class regex_check {
    public static Boolean If_psd_legal(String test)
    {
        String pattern = "/^(\\w){6,20}$/";//要匹配的正则表达式
        return  Pattern.matches(pattern,test);
    }
    public  static Boolean If_mail_legal(String test)
    {

    }

}

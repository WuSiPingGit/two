package wsp.com.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMailUtil {
	//：目标邮箱， 标题 ， 主题内容。
	    public static  String SendQQMail(String Recipient)throws AddressException,MessagingException{
	        Properties properties = new Properties();
	        String title = "注册";
	        int check = GetRamomMathUtil.GetRamdom(100, 2000, true);
	        int checkOne = GetRamomMathUtil.GetRamdom(60, 100, true);
	        char a = (char)checkOne;
	        String msgBody = "验证码:"+check+a;
	        properties.setProperty("mail.host", "smtp.qq.com");// 主机名
	        properties.setProperty("mail.auth", "true");
	        properties.setProperty("mail.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
	        properties.setProperty("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
	        // 得到回话对象
	        Session session = Session.getInstance(properties);
	        // 获取邮件对象
	        Message message = new MimeMessage(session);
	        // 设置发件人邮箱地址
	        message.setFrom(new InternetAddress("482597351@qq.com"));
	        // 设置收件人邮箱地址
	        message.setRecipient(Message.RecipientType.TO, new InternetAddress(Recipient));//一个收件人
	        // 设置邮件标题
	        message.setSubject(title);
	        // 设置邮件内容
	        message.setText(msgBody);
	        // 得到邮差对象
	        Transport transport = session.getTransport();
	        // 连接自己的邮箱账户
	        transport.connect("482597351@qq.com", "zdpslabrjoffcahf");
	        // 发送邮件
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	        return msgBody;
	    }
}

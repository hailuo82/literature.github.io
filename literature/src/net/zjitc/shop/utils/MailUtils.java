package net.zjitc.shop.utils;

import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import net.zjitc.shop.user.domain.User;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * 发送邮件的工具类
 * @author Administrator
 *
 */
public class MailUtils {
	  	    
	    /**
	     * 带有html的邮件
	     * @throws MessagingException
	     */
	    public static void sendMail(User user){
	    	
	    	JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();  
	        // 设定mail服务器
	        senderImpl.setHost("smtp.sina.com");  
	  
	        // 建立邮件消息
	        MimeMessage mailMessage = senderImpl.createMimeMessage();  
	        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,"utf-8");  
	        try {
	        	
	        	// 设置收件人  
	        	messageHelper.setTo(user.getEmail());  
	        	// 设置寄件人
	        	messageHelper.setFrom("w692325744@sina.com");  
	        	messageHelper.setSubject("来自literature show的激活邮件");  
	        	// true 表示启动HTML格式的邮件  
				messageHelper.setText("<h2>账号："+user.getUsername()+"  密码："+user.getPassword()+"</h2><h1>点击下面的链接激活您的账户(已激活的，请忽略)</h1>" +
						"<h3><a href='http://localhost:8080/literature/user_active?code="+user.getCode()+"'>http://www.literatureshow.com?code="+user.getCode()+"</a></h3>", true);
				senderImpl.setUsername("w692325744@sina.com"); // 根据自己的情况,设置username  
				senderImpl.setPassword("89995623"); // 根据自己的情况, 设置password  
				Properties prop = new Properties();  
				prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确  
				prop.put("mail.smtp.timeout", "25000");  
				senderImpl.setJavaMailProperties(prop);  
				// 发送邮件  
				senderImpl.send(mailMessage);  
			} catch (MessagingException e) {
				e.getMessage();
			}  
	  
	    }
}

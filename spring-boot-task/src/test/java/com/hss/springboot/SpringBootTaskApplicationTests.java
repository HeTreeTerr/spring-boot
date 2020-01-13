package com.hss.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTaskApplicationTests {
    @Autowired
    JavaMailSenderImpl javaMailSender;
    //qq邮件发送
    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("小甜甜");
        message.setText("中秋快乐");

        message.setFrom("3110708879@qq.com");
        //发送地址
        message.setTo("hss321hss@qq.com");
        javaMailSender.send(message);
    }
    @Test
    public void test1() throws MessagingException {
        //创建一个复杂的邮件
        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);

        //邮件设置
        helper.setSubject("通知，今晚开会");
        helper.setText("<b style='color:red'>今晚猎个痛快。</b>",true);

        helper.setFrom("3110708879@qq.com");
        //上传附件
        helper.addAttachment("butterfly.jpg",new File("C:\\Users\\lenovo\\Pictures\\butterfly.jpg"));
        //发送地址
        helper.setTo("1105767827@qq.com");
        javaMailSender.send(mimeMailMessage);
    }

}

package com.hss.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * <p>
 * 文件接收
 * </p>
 *
 * @author Hss
 * @date 2024-08-23
 */
@Service
public class ReceiveEmailService {

    Logger log = LoggerFactory.getLogger(getClass());

    public void receiveEmail() {
        //POP3主机名
        //String host = "pop3.163.com";
        String host = "pop.qq.com";
        //设置传输协议
        String protocol = "pop3";
        //用户账号
        String username = "3110708879@qq.com";
        //密码或者授权码
        String password = "hsyvwpjupufmdgai";
        //端口号
        Integer port = 995;

        /*
         * 获取Session
         */
        Properties props = new Properties();
        //协议
        props.setProperty("mail.store.protocol", protocol);
        //POP3主机名
        props.setProperty("mail.pop3.host", host);
        props.setProperty("mail.smtp.auth", "true");
        // 需要认证
        props.setProperty("mail.pop3.auth", "true");
        // SSL 连接
        props.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        // 不允许使用非 SSL 连接
        props.setProperty("mail.pop3.socketFactory.fallback", "false");
        Session session = Session.getInstance(props);
        session.setDebug(true);

        /*
         * 获取Store，一个Store对象表示整个邮箱的存储
         *
         */
        URLName urlName = new URLName(protocol, host, port, null, username, password);
        try{
            Store store = session.getStore(urlName);
            //连接邮件服务器
            store.connect();
            //要收取邮件，我们需要通过Store访问指定的Folder（文件夹），通常是INBOX表示收件箱
            //获取邮箱的邮件夹，通过pop3协议获取某个邮件夹的名称只能为inbox，不区分大小写
            Folder folder = store.getFolder("INBOX");
            //打开邮箱方式（邮件访问权限），这里的只读权限
            folder.open(Folder.READ_ONLY);
            //打印邮件总数/新邮件数量/未读数量/已删除数量:
            System.out.println("Total messages: " + folder.getMessageCount());
            System.out.println("New messages: " + folder.getNewMessageCount());
            System.out.println("Unread messages: " + folder.getUnreadMessageCount());
            System.out.println("Deleted messages: " + folder.getDeletedMessageCount());

            // 获得邮件夹Folder内的所有邮件Message对象，一个Message代表一个邮件
            Message[] messages = folder.getMessages();
            for (Message message : messages) {
                /*解析邮件*/
                System.out.println("=====================");
                //获取主题
                String subject = message.getSubject();
                System.out.println("主题:" + subject);
                System.out.println("时间:" + message.getSentDate());
                // 获取邮件内容
                Object content = message.getContent();
                if (content instanceof MimeMultipart) {
                    MimeMultipart multipart = (MimeMultipart) content;
                    for (int i = 0; i < multipart.getCount(); i++) {
                        BodyPart part = multipart.getBodyPart(i);

                        // 检查是否为正文
                        //if (part.isMimeType("text/plain;") || part.isMimeType("text/html;")) {
                        if(part.getContentType().startsWith("multipart/alternative")){
                            String result = new BufferedReader(new InputStreamReader(part.getInputStream()))
                                    .lines().collect(Collectors.joining(System.lineSeparator()));
                            System.out.println("正文内容:" + result);
                            //System.out.println(part.getContent());
                        } else if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                            String fileName = part.getFileName();
                            if (fileName != null) {
                                System.out.println("附件: " + fileName);
                            } else {
                                System.out.println("附件没有文件名，无法保存");
                            }
                        }
                    }
                }
            }

            //传入true表示删除操作会同步到服务器上（即删除服务器收件箱的邮件），无参方法默认传递true
            folder.close(false);
            store.close();
        }catch (Exception e){
            log.error("接收失败！",e);
        }

    }
}

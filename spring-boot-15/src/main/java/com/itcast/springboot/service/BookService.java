package com.itcast.springboot.service;

import com.itcast.springboot.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    //消息监听
    @RabbitListener(queues = "hss.news")
    public void recevice(Book book){
        System.out.println("收到消息");
    }
    @RabbitListener(queues = "hss")
    public void recevicece(Message message){
        System.out.println(message.getMessageProperties()+"-------"+message.getBody());
    }

}

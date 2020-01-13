package com.itcast.springboot;

import com.itcast.springboot.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * springBoot测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAmqpApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpAdmin amqpAdmin;
    /**
     * 1.单播（点对点）
     */
    @Test
    public void contextLoads() {
        //Message需要自己构造一个;定制消息体内容和消息头
        //rabbitTemplate.send(exchangs,routeKey,message);

        //object默认当成消息体，只需要传入要发送的对象,自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routeKey,object);
//        Map<String,Object> map = new HashMap<>();
//        map.put("msg","这是第一个消息");
//        map.put("data", Arrays.asList("hello word",123,true));
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("exchange.direct","hss",new Book("hpp","ennnnnn"));
    }
    /**
     * 接收消息
     * 接收消息后，消息从消息队列中移除
     */
    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("hss.news");
        System.out.println(o.getClass());
        System.out.println(o);

       /*class java.util.HashMap
        {msg=这是第一个消息, data=[hello word, 123, true]}*/
    }
    /**
     * 创建Exchange及关系绑定
     */
    @Test
    public void creatExchange(){

//        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
//        System.out.println("创建完成");

//        amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
//        System.out.println("队列创建完成");
//        amqpAdmin.declareBinding(new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.haha",null));
//        System.out.println("绑定成功");

//        amqpAdmin.removeBinding(new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.haha",null));
//        System.out.println("解除绑定");
//        amqpAdmin.deleteQueue("amqpadmin.queue");
//        System.out.println("删除队列");
        amqpAdmin.deleteExchange("amqpadmin.exchange");
        System.out.println("删除Exchange");
    }
}

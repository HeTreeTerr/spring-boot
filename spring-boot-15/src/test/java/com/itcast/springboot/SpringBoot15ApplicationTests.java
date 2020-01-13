package com.itcast.springboot;

import com.itcast.springboot.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot15ApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
        //rabbitTemplate.convertAndSend(exchange,routeKey,object);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("hello word",123,true));
        //对象被默认序列化以后发送出去
        rabbitTemplate
                .convertAndSend("exchange.direct",
                        "hss.news",new Book("hss","小飞飞"));
    }

    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("hss.news");
        System.out.println(o.getClass());
        System.out.println(o);

       /*class java.util.HashMap
        {msg=这是第一个消息, data=[hello word, 123, true]}*/
    }
    /**
     * 广播
     */
    @Test
    public void sendMsg(){
        rabbitTemplate
                .convertAndSend("exchange.fanout",
                        "",new Book("hpp","和"));
    }
}

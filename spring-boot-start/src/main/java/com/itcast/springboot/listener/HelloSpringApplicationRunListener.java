package com.itcast.springboot.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class HelloSpringApplicationRunListener implements SpringApplicationRunListener {
    public HelloSpringApplicationRunListener(SpringApplication application,String[] args){

    }

    @Override
    public void starting() {//监听容器开始
        System.out.println("SpringApplicationRunListener..starting..");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {//准备好环境
        Object o = environment.getSystemProperties().get("os.name");
        System.out.println("SpringApplicationRunListener..environmentPrepared.."+o);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {//ioc容器准备好了
        System.out.println("SpringApplicationRunListener..contextPrepared..");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {//Ioc容器加载完成
        System.out.println("SpringApplicationRunListener..contextLoaded..");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {//环境加载完成
        System.out.println("SpringApplicationRunListener..started..");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {//开始运行
        System.out.println("SpringApplicationRunListener..running..");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {//报错
        System.out.println("SpringApplicationRunListener..failed..");
    }
}

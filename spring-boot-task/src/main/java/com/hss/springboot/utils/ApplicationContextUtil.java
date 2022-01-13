package com.hss.springboot.utils;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    /**
     * 获取bean
     * @param name
     * @return
     * @throws BeansException
     */
    public static Object getBean(String name) throws BeansException {
        Object o = applicationContext.getBean(name);
        return o;
    }

    public static Object getBean(Class<?> requiredType) throws BeansException {
        Object o = applicationContext.getBean(requiredType);
        return o;
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }


}


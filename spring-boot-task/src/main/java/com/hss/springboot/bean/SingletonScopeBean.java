package com.hss.springboot.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 单例bean
 */
@Component
@Scope(value = "singleton")
public class SingletonScopeBean {

    public SingletonScopeBean(){
        System.out.println("SingletonScopeBean is loadling...");
    }
}

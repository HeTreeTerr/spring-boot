package com.hss.springboot.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 多例bean
 */
@Component
@Scope(value = "prototype")
public class PrototypeScopeBean {

    public PrototypeScopeBean(){
        System.out.println("PrototypeScopeBean is loadling...");
    }
}

package com.hss.springboot.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * globalSession bean
 */
@Component
@Scope(value = "globalSession")
public class GlobalSessionScopeBean {

    public GlobalSessionScopeBean(){
        System.out.println("GlobalSessionScopeBean is loadling...");
    }
}

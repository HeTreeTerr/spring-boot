package com.hss.springboot.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * session bean
 */
@Component
@Scope(value = "session")
public class SessionScopeBean {

    public SessionScopeBean(){
        System.out.println("SessionScopeBean is loadling...");
    }
}

package com.hss.springboot.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * request bean
 */
@Component
@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestScopeBean {

    public RequestScopeBean(){
        System.out.println("RequestScopeBean is loadling...");
    }
}

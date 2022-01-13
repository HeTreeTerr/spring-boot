package com.hss.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * bean 作用域传递
 */
@Component
@Scope(value = "singleton")
public class ScopeTransferBean {

    @Autowired
    private RequestScopeBean requestScopeBean;

    public ScopeTransferBean(){
        System.out.println("ScopeTransferBean is loadling...");
    }

    public RequestScopeBean getRequestScopeBean(){
        return requestScopeBean;
    }
}

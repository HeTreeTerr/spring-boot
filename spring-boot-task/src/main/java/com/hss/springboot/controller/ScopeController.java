package com.hss.springboot.controller;

import com.hss.springboot.bean.GlobalSessionScopeBean;
import com.hss.springboot.bean.RequestScopeBean;
import com.hss.springboot.bean.ScopeTransferBean;
import com.hss.springboot.bean.SessionScopeBean;
import com.hss.springboot.utils.ApplicationContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * spring bean 作用域使用
 */
@RestController
public class ScopeController {

    Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/request")
    public String request(){
        RequestScopeBean bean = (RequestScopeBean)ApplicationContextUtil.getBean(RequestScopeBean.class);
        log.info("bean address={}", bean);
        return "request";
    }

    @RequestMapping(value = "/session")
    public String session(){
        SessionScopeBean bean = (SessionScopeBean)ApplicationContextUtil.getBean(SessionScopeBean.class);
        log.info("bean address={}", bean);
        return "session";
    }

    @RequestMapping(value = "/globalSession")
    public String globalSession(){
        GlobalSessionScopeBean bean = (GlobalSessionScopeBean)ApplicationContextUtil.getBean(GlobalSessionScopeBean.class);
        log.info("bean address={}", bean);
        return "globalSession";
    }

    @RequestMapping(value = "/scopeTransfer")
    public String scopeTransfer(){
        ScopeTransferBean bean = (ScopeTransferBean) ApplicationContextUtil.getBean(ScopeTransferBean.class);
        log.info("bean address={}", bean);
        log.info("getRequestScopeBean address={}", bean.getRequestScopeBean());
        return "scopeTransfer";
    }
}

package com.hss.springboot.service;

import com.hss.springboot.bean.PrototypeScopeBean;
import com.hss.springboot.bean.SingletonScopeBean;
import com.hss.springboot.utils.ApplicationContextUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * spring bean 生命周期
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanScopeTest {

    Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 单例
     */
    @Test
    public void singletonScope(){
        log.info("bean={}",ApplicationContextUtil.getBean(SingletonScopeBean.class));
        log.info("bean={}",ApplicationContextUtil.getBean(SingletonScopeBean.class));
        log.info("bean={}",ApplicationContextUtil.getBean(SingletonScopeBean.class));
    }

    /**
     * 多例
     */
    @Test
    public void prototypeScope(){
        log.info("bean={}",ApplicationContextUtil.getBean(PrototypeScopeBean.class));
        log.info("bean={}",ApplicationContextUtil.getBean(PrototypeScopeBean.class));
        log.info("bean={}",ApplicationContextUtil.getBean(PrototypeScopeBean.class));
    }


}

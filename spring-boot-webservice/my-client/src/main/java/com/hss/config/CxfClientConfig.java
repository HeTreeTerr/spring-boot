package com.hss.config;

import com.hss.wsdl.UserPortType;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfClientConfig {

    private final static String SERVICE_ADDRESS = "http://localhost:8001/ws/user";

    @Bean("cxfProxy")
    public UserPortType createUserPortTypeProxy() {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setAddress(SERVICE_ADDRESS);
        jaxWsProxyFactoryBean.setServiceClass(UserPortType.class);
        return (UserPortType) jaxWsProxyFactoryBean.create();
    }
}

package com.hss.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * WebService 配置
 * </p>
 *
 * @author Hss
 * @date 2023-08-12
 */
@Configuration
@Data
public class MyWebServiceConfig {

    /**
     * webservice访问地址
     */
    @Value(value = "${com.hss.webservice.url:#{null }}")
    private String webserviceUrl;

    /**
     * getUserName功能的方法名
     */
    @Value(value = "${com.hss.methodName.getUserName}")
    private String getUserNameMethodName;

}

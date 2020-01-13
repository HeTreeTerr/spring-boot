package com.itcast.springboot.config;

import com.itcast.springboot.filter.MyFilter;
import com.itcast.springboot.listener.MyListener;
import com.itcast.springboot.servlet.Myservlet;
import com.itcast.springboot.servlet.Myservlet1;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.servlet.ServletContextListener;
import java.util.Collection;

@Configuration
public class MyServerConfig {

    //服务器配置定制
//    在Spring Boot2.0以上配置嵌入式Servlet容器时EmbeddedServletContainerCustomizer类不存在，
//    经网络查询发现被WebServerFactoryCustomizer替代
    //@Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                //设置服务器端口号
                factory.setPort(8083);
            }
        };
    }
    //设置servet.一个函数可以设置一个servlet文件.一个servlet文件可以有多个路径
    //@Bean
    public ServletRegistrationBean<Servlet> myServlet(){
        ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<>();
        servletRegistrationBean.setServlet(new Myservlet());
        servletRegistrationBean.addUrlMappings("/myServlet");
        //启动顺序
        servletRegistrationBean.setLoadOnStartup(1);
//        servletRegistrationBean.setServlet(new Myservlet1());
//        servletRegistrationBean.addUrlMappings("/myServlet1");
//        servletRegistrationBean.addUrlMappings("/myServlet2");
        return  servletRegistrationBean;
    }
    //@Bean
    public ServletRegistrationBean<Servlet> myServlet1(){
        ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<>();
        servletRegistrationBean.setServlet(new Myservlet1());
        servletRegistrationBean.addUrlMappings("/myServlet1");
        servletRegistrationBean.addUrlMappings("/myServlet2");
        servletRegistrationBean.setLoadOnStartup(1);
        return  servletRegistrationBean;
    }
    //设置Filter拦截器
    //@Bean
    public FilterRegistrationBean<Filter> myFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MyFilter());
        //设置要拦截的路径，不设置是默认拦截所有请求
        filterRegistrationBean.addUrlPatterns("/hello");
        //filterRegistrationBean.
        return filterRegistrationBean;
    }
    //@Bean
    public ServletListenerRegistrationBean<ServletContextListener> myListener(){
        ServletListenerRegistrationBean<ServletContextListener> contextListenerServletListenerRegistrationBean
                = new ServletListenerRegistrationBean<>();
        contextListenerServletListenerRegistrationBean.setListener(new MyListener());

        return contextListenerServletListenerRegistrationBean;
    }
}

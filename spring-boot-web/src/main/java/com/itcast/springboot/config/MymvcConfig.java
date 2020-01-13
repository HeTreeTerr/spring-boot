package com.itcast.springboot.config;

import com.itcast.springboot.component.LoginHandlerInterceptor;
import com.itcast.springboot.component.MyLocaleResolver;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

//@EnableWebMvc
@Configuration
public class MymvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       // super.addViewControllers(registry);
        //浏览器发送/springboot请求，来到success页面。
        registry.addViewController("/springboot").setViewName("success");
    }

    //所有的WebMvcConfigurerAdapter可以一起起作用,将组件注册到容器
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){

        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            //设置视图映射
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {

                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
            //设置拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //springboot已做好静态资源映射
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/index.html","/","/user/login","/user/signOut"
//                                ,"/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg"
//                                ,"/**/*.ico","/**/*.svg");
            }
        };
        return adapter;
    }
    //向容器中注入国际化资源配置
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


}

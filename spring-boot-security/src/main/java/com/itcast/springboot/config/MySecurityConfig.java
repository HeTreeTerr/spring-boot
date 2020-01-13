package com.itcast.springboot.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//开启spring安全注解
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //开启自动配置的登录功能,自定义登录页面
        http.formLogin().usernameParameter("user").passwordParameter("pwd").loginPage("/userlogin");
        //1./Login来到登录页
        //2.如果登录错误重定向到/Login?error表示登录失败
        //3.默认post形式的/login代表处理登录 username password
        //4.一旦定制loginpage,那么loginpage的post请求就是登录
        //开启退出功能
        http.logout().logoutSuccessUrl("/");
        //访问/loginout请求，清空session

        //开启记住我功能
        http.rememberMe().rememberMeParameter("rember");
        //登录成功以后，将cookie发送给浏览器保存，以后访问页面带上这个cookie,只要通过检查就可以免登陆
        //点击注销会删除cookie
    }
    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication().withUser("hss").password("123456").roles("VIP1","VIP2")
                .and().withUser("hww").password("123456").roles("VIP2","VIP3")
                .and().withUser("lll").password("123456").roles("VIP1","VIP3");
    }
}

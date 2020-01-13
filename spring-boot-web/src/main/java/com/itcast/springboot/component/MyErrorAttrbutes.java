package com.itcast.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
@Component
public class MyErrorAttrbutes extends DefaultErrorAttributes {
    //springboot默认报错与自定义报错信息整合
    //返回的map就是页面和json数据可以获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map= super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","何家面馆");
        //异常处理器携带的数据 0代表request域
        Map<String, Object> ext = (Map<String, Object>)webRequest.getAttribute("ext",0);
        map.put("ext",ext);
        return map;
    }

}

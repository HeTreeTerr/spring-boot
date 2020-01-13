package com.itcast.springboot.exception;
//自定义用户异常处理
public class UserNotExisException extends  RuntimeException{

    public UserNotExisException() {
        super("用户不存在");
    }
}

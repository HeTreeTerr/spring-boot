package com.hss.controller;

import com.hss.domain.User;
import com.hss.export.UserExportEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/exportUser",method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportUser(){
        List<User> users = new ArrayList<>();
        users.add(new User(1L,"hss",new Date()));
        users.add(new User(2L,"htj",new Date()));
        users.add(new User(3L,"htx",new Date()));
        return UserExportEntity.exportUserExcel(users);
    }

    @RequestMapping("/importUser")
    @ResponseBody
    public String file(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        List<User> users = UserExportEntity.importUserList(file);
        if(users.size() > 0){
            for(User user : users){
                logger.info("user={}",user);
            }
        }else{
            return "error";
        }
        return "success";
    }
}

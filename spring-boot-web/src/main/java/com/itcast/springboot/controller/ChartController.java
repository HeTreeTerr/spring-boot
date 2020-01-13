package com.itcast.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChartController {
    @ResponseBody
    @RequestMapping(value = "/bar")
    public String[] bar(){
        String [] bars = new String[7];
        bars[0]="295";
        bars[1]="410";
        bars[2]="455";
        bars[3]="614";
        bars[4]="730";
        bars[5]="700";
        bars[6]="840";
        return bars;
    }
}

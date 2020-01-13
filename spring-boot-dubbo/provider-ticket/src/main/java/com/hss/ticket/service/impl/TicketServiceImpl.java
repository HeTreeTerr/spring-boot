package com.hss.ticket.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.hss.ticket.service.TicketService;
import org.springframework.stereotype.Component;

@Component
@Service  //dubbo提供的service标签，将服务发布出去
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "<<厉害了，我的国>>";
    }
}

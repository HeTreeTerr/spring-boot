package com.hss.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hss.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Reference
    TicketService ticketService;

    public String getTicket(){
        return ticketService.getTicket();
    }
}

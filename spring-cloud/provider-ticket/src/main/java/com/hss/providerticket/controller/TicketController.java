package com.hss.providerticket.controller;

import com.hss.providerticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;
    @GetMapping(value = "/ticket")
    public String getTicket(){
        System.out.println("8002");
        return ticketService.getTicket();
    }
}

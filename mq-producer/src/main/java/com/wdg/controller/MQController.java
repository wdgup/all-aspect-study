package com.wdg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wdg.mq.MessageService;

@RestController
public class MQController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/testMessage")
    public String testMessage(){
        messageService.createMessage();
        return "ok";
    }

    @GetMapping("/testExchange")
    public String testExchange(){
        messageService.createExchangee();
        return "ok";
    }
}

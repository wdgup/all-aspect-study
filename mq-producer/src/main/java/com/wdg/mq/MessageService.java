package com.wdg.mq;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class MessageService {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void createMessage(){
        rabbitTemplate.convertAndSend("sendMessage","hello world");
    }

    public void createExchangee() {
        JSONObject obj = new JSONObject();
        obj.put("code","200");
        obj.put("message","success");
        rabbitTemplate.convertAndSend("com.wdg.userService","",obj);
    }
}

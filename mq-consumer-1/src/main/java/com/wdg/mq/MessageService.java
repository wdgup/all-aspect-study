package com.wdg.mq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageService {

    @RabbitHandler
    @RabbitListener(queues = "sendMessage")
    public Object consumer(Message message){
        System.out.println("接收到消息："+message);
        return null;
    }

    @RabbitHandler
    @RabbitListener(queues = "messageA")
    public Object consumermessageA(Message message){
        System.out.println("接收到消息messageA："+message);
        return null;
    }

    @RabbitHandler
    @RabbitListener(queues = "messageB")
    public Object consumermessageB(Message message){
        System.out.println("接收到消息messageB："+message);
        return null;
    }
}

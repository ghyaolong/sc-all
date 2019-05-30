package com.yao.sc.scamqp.mq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Sender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Map<String,String> msg){
        rabbitTemplate.convertAndSend("foo",msg);
    }
}
package com.yao.sc.scamqp.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

import java.time.LocalDateTime;
import java.util.Map;

@Configuration
@RabbitListener(queues = "foo")
public class Listener {

    @Bean
    public Queue fooQueue() {
        return new Queue("foo");
    }

    @RabbitHandler
    public void process(@Payload Map<String, String> map) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalDateTime ld = LocalDateTime.now();
        System.out.println("消费者消费了[name:"+map.get("name")+";password="+map.get("password")+"]"+ld);
    }
}

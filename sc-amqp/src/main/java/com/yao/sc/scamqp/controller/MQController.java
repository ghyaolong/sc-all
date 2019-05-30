package com.yao.sc.scamqp.controller;

import com.yao.sc.scamqp.mq.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mq")
public class MQController {

    @Autowired
    private Sender sender;

    @GetMapping("/send")
    public void testMQ(String name,String password){
        Map map = new HashMap<String,String>();
        map.put("name","zhangsan");
        map.put("password","123456");
        sender.send(map);
    }
}

package com.yao.sc.serviceribbon.controller;


import com.yao.sc.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;


    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) throws ExecutionException, InterruptedException {
        return helloService.hiService(name).get();
    }
}




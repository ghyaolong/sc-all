package com.yao.sc.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;


@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;
    /**
     * 同步实现断路器
     */
    /*@HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

    public String hiError(String name){
        return "hi,"+name+",sorry,error!";
    }*/


    /**
     * 异步实现断路器
     * @param name
     * @return
     */
    @HystrixCommand
    public Future<String> hiService(String name) {
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
            }
        };
    }


}



package com.yao.sc.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.netflix.hystrix.exception.HystrixBadRequestException;
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
    @HystrixCommand(ignoreExceptions = {HystrixBadRequestException.class},fallbackMethod = "hiServiceHystrix")
    public Future<String> hiService(String name) {
        return new AsyncResult<String>() {
            @Override
            public String invoke() {
                return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
            }
        };
    }

    /**
     * hiService方法抛出不同的异常做不同的处理
     * @param name
     * @param t
     * @return
     */
    public String hiServiceHystrix(String name,Throwable t){
        if(t.getMessage().equals("ABCXXXXException")){
            //todo
        }else if(t.getMessage().equals("DEFXXXXException")){
            //todo
        }
        return String.format("name:", t.getMessage());
    }



}



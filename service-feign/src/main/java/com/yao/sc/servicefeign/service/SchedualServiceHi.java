package com.yao.sc.servicefeign.service;


import com.sc.model.User;
import com.yao.sc.servicefeign.hystric.SchedualServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    User hello2(@RequestHeader("name") String name, @RequestHeader("age")Integer age);

    @RequestMapping(value = "hello3",method = RequestMethod.POST)
    User hello3(@RequestBody User user);
}



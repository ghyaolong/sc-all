package com.yao.sc.servicefeign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yao.sc.servicefeign.service.SchedualServiceHi;

@RestController
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;
    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name){
        return schedualServiceHi.sayHiFromClientOne(name);
    }
}




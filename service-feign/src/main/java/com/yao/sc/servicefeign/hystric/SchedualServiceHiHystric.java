package com.yao.sc.servicefeign.hystric;

import com.sc.model.User;
import com.yao.sc.servicefeign.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }

    @Override
    public User hello2(String name, Integer age) {
        return null;
    }

    @Override
    public User hello3(User user) {
        return null;
    }
}


package com.hgsoft.springcloud.sayhelloconsumerhystrix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        String greeting = restTemplate.getForObject("http://say-hello-provider-eureka-client/greeting",String.class);
        return String.format("%s,%s!",greeting,name);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}


package com.hgsoft.springcloud.sayhelloconsumerfeign;

import com.hgsoft.springcloud.sayhelloconsumerfeign.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class SayHelloConsumerFeignApplication {
    private static Logger log = LoggerFactory.getLogger(SayHelloConsumerFeignApplication.class);
    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello invoke");
        return helloService.greeting();
    }

    public static void main(String[] args) {
        SpringApplication.run(SayHelloConsumerFeignApplication.class, args);
    }

}


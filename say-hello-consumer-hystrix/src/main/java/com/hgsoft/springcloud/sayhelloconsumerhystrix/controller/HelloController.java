package com.hgsoft.springcloud.sayhelloconsumerhystrix.controller;

import com.hgsoft.springcloud.sayhelloconsumerhystrix.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/hi")
    public String hi(@RequestParam(value="name",defaultValue = "springcloud") String name){
        String greeting = this.helloService.hiService(name);
        return String.format("%s,%s!",greeting,name);
    }
}

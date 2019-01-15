package com.hgsoft.springcloud.serversidecarthirdprovider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class DemoController {
    @RequestMapping(value="/health")
    public Mono<String> healteh(){
        Mono<String> mono = Mono.just("{\"status\":\"UP\"}");
        return mono;

    }
    @RequestMapping(value="/query",method= RequestMethod.GET)
    public String query(){
            return "query";

    }
    @RequestMapping(value="/list",method= RequestMethod.GET)
    public String list(){
        return "list";

    }
}

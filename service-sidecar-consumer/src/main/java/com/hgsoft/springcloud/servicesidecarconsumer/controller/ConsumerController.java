package com.hgsoft.springcloud.servicesidecarconsumer.controller;

import com.hgsoft.springcloud.servicesidecarconsumer.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ConsumerController {
    private static Logger log = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    ConsumerService consumerService;

    @RequestMapping("/query")
    public String query (){
        System.out.println("============ConsumerController query=============");
        return consumerService.query();
    }

    @RequestMapping("/list")
    public String list (){
        System.out.println("============ConsumerController list=============");
        return consumerService.list();
    }
}

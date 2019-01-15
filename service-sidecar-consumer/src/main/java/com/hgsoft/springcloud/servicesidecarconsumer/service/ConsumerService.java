package com.hgsoft.springcloud.servicesidecarconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//@ FeignClient（“服务名”）
@FeignClient("service-sidecar")
public interface ConsumerService {
    @RequestMapping("/query")
    public String query() ;

    @RequestMapping("/list")
    public String list() ;
}

package com.hgsoft.springcloud.zipkin.sayhelloconsumerfeignzipkin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//@ FeignClient（“服务名”）
@FeignClient("say-hello-provider-eureka-client")
public interface HelloService {
    @RequestMapping("/greeting")
    String greeting() ;

//     String greeting (@RequestParam(value = "name") String name) ;
}

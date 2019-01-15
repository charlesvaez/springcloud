package com.hgsoft.springcloud.serviceconfigclientlocal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class ServiceConfigClientLocalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConfigClientLocalApplication.class, args);
    }
    //手动刷新配置 http://localhost:9001/actuator/refresh 必须是post请求
    //程序的入口类，写一个API接口“／hi”，返回从配置中心读取的foo变量的值
    @Value("${foo}")
    private String foo;

    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }
}


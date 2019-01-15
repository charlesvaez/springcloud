package com.hgsoft.springcloud.serviceconfigserverlocal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ServiceConfigServerLocalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConfigServerLocalApplication.class, args);
    }

}


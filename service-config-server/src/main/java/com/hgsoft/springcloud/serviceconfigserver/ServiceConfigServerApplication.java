package com.hgsoft.springcloud.serviceconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ServiceConfigServerApplication {
    //http://localhost:8888/foo/dev
    public static void main(String[] args) {
        SpringApplication.run(ServiceConfigServerApplication.class, args);
    }

}


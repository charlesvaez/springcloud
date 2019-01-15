package com.hgsoft.springcloud.servicestreamtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ServiceStreamTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceStreamTestApplication.class, args);
    }

}


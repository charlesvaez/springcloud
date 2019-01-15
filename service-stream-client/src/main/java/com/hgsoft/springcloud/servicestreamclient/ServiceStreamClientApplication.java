package com.hgsoft.springcloud.servicestreamclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class ServiceStreamClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceStreamClientApplication.class, args);
    }

    @StreamListener(Sink.INPUT)
    public void recieve(Object payload){
        System.out.println(payload);
    }
}


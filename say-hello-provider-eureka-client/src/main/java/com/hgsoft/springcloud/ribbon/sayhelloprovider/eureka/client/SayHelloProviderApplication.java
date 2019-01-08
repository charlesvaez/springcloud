package com.hgsoft.springcloud.ribbon.sayhelloprovider.eureka.client;

import brave.sampler.Sampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@SpringBootApplication
public class SayHelloProviderApplication {
    private static Logger log = LoggerFactory.getLogger(SayHelloProviderApplication.class);

    @RequestMapping("/greeting")
    public String greet(){
        System.out.println("greet");
        List<String> greetings = Arrays.asList("hello1","hello2","hello3");
        Random r = new Random();
        return greetings.get(r.nextInt(3));
    }

    @RequestMapping("/")
    public String home(){
        return "Hi!";
    }

    /*增加
    --server.port=6666
    改变端口号*/
    public static void main(String[] args) {
        SpringApplication.run(SayHelloProviderApplication.class, args);
    }
    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

}


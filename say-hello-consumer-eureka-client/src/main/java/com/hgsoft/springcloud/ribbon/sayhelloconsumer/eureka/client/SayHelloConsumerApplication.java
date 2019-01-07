package com.hgsoft.springcloud.ribbon.sayhelloconsumer.eureka.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class SayHelloConsumerApplication {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String hi(@RequestParam(value="name",defaultValue = "springcloud") String name){
//       直接访问
//        String greeting = this.restTemplate.getForObject("http://localhost:5555/greeting",String.class);

        //负载均衡方式
        //say-hello-provider-eureka-client对应到application.properties配置文件的say-hello-provider-eureka-client.ribbon.listOfServers配置
        //增加@RibbonClient(name="say-hello-provider",configuration = SayHelloConfiguration.class)注解
        //增加SayHelloConfiguration类
        //在RestTemplate增加@LoadBalanced注解
        String greeting = this.restTemplate.getForObject("http://say-hello-provider-eureka-client/greeting",String.class);
        return String.format("%s,%s!",greeting,name);
    }

    public String hello(){
        System.out.println("123");
        return "hello";
    }
    public static void main(String[] args) {
        SpringApplication.run(SayHelloConsumerApplication.class, args);
    }

}


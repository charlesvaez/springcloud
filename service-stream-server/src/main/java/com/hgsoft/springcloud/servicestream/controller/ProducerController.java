package com.hgsoft.springcloud.servicestream.controller;

import com.hgsoft.springcloud.servicestream.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    @Autowired
    private SendService sendService;

   // @Resource(name="shop_output")
    //public MessageChannel sendShopMessageChannel;

    @RequestMapping("/send/{msg}")
    public String send(@PathVariable("msg") String msg){
        System.out.println("msg: "+msg);
//        boolean isSendSuccess = sendShopMessageChannel.send(MessageBuilder.withPayload(msg).build());
//        return isSendSuccess ? "发送成功" : "发送失败";
        sendService.sendMsg(msg);
        return "发送成功";
    }
}
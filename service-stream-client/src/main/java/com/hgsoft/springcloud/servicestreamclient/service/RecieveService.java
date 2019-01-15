package com.hgsoft.springcloud.servicestreamclient.service;

//消息接受端，stream给我们提供了Sink,Sink源码里面是绑定input的，要跟我们配置文件的input关联的。
//@EnableBinding(Sink.class)
public class RecieveService {

//    @StreamListener(Sink.INPUT)
    public void recieve(Object payload){
        System.out.println(payload);
    }
}

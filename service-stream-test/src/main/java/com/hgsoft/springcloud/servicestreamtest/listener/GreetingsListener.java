package com.hgsoft.springcloud.servicestreamtest.listener;

import com.hgsoft.springcloud.servicestreamtest.channel.GreetingsStreams;
import com.hgsoft.springcloud.servicestreamtest.entity.Greetings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(GreetingsStreams.class)
public class GreetingsListener {
    private static Logger log = LoggerFactory.getLogger(GreetingsListener.class);

    //@StreamListener(GreetingsStreams.INPUT)
    public void handleGreetings(@Payload Greetings greetings) {
        log.info("Received greetings: {}", greetings);
    }

    @StreamListener(GreetingsStreams.INPUT)
    public void process(Message<Greetings> message) {
        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        if (acknowledgment != null) {
            System.out.println("Acknowledgment provided");
            Greetings greetings = message.getPayload();
            log.info("Received greetings: {}", greetings);
            acknowledgment.acknowledge();
        }
    }
}

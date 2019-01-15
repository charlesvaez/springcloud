package com.hgsoft.springcloud.servicestreamtest.config;

import com.hgsoft.springcloud.servicestreamtest.channel.GreetingsStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(GreetingsStreams.class)
public class StreamsConfig {
}
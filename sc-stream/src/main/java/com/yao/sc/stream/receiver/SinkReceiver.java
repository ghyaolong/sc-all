package com.yao.sc.stream.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@Slf4j
@EnableBinding(Sink.class)
public class SinkReceiver {

    @StreamListener(Sink.INPUT)
    private void receive(Object object){
        log.info("payreload:"+object);
    }

}

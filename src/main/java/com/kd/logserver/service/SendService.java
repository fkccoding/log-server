package com.kd.logserver.service;

import com.kd.logserver.domain.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @Author: www.chuckfang.top
 * @Date: 2018/12/20 18:50
 */
@EnableBinding(Source.class)
public class SendService {

    @Autowired
    private Source source;

    public String sendMessage(Log log){
        boolean send = source.output().send(MessageBuilder.withPayload(log).build());
        return send ? "SEND OK!":"SEND FAIL";
    }
}

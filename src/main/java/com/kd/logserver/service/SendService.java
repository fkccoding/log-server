package com.kd.logserver.service;

import com.kd.logserver.domain.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;


/**
 * @Author: www.chuckfang.top
 * @Date: 2018/12/20 18:50
 */
@EnableBinding(Processor.class)
public class SendService {

    private Logger logger = LoggerFactory.getLogger(SendService.class);

    @Autowired
    private Source source;

    public boolean sendMessage(Log log){
        return source.output().send(MessageBuilder.withPayload(log).build());
    }

    @StreamListener(Processor.INPUT)
    public void receive(boolean feedback) {
        logger.info("收到反馈！存储"+(feedback?"成功":"失败"));
    }

}

package com.kd.logserver.controller;

import com.kd.logserver.domain.Log;
import com.kd.logserver.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: www.chuckfang.top
 * @Date: 2018/12/25 10:13
 */
@RestController
public class LogController {

    @Autowired
    SendService sendService;

    //TODO 这是log服务提供方需要写的代码
    @PostMapping("/log_save")
    public String logSave(@RequestBody Log log){
        System.out.println("log: "+log);

        //发送到消息队列中，然后返回状态消息。
        return sendService.sendMessage(log);
    }
}

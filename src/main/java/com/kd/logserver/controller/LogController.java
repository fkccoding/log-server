package com.kd.logserver.controller;

import com.kd.logserver.domain.Log;
import com.kd.logserver.service.SendService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: www.chuckfang.top
 * @Date: 2018/12/25 10:13
 * @update: ling 2018/12/29 15:04 增加swagger2注解，生成restful API在线文档
 */
@RestController
public class LogController {

    @Autowired
    SendService sendService;

    //TODO 这是log服务提供方需要写的代码
    @PostMapping("/log_save")
    @ApiOperation(value="发送日志",notes="接收日志，发送进kafka消息队列中")
    public String logSave(@RequestBody Log log){
//        System.out.println("log: "+log);

        //发送到消息队列中，然后返回状态消息。
        boolean send = sendService.sendMessage(log);
        return send?"发送成功！":"发送失败";
    }
}

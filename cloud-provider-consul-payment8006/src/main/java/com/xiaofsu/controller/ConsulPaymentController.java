package com.xiaofsu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author xiaoFsu
 * @Date 2020/4/28 15:38
 * @Version 1.0
 */
@RequestMapping("/payment")
@RestController
@Slf4j
public class ConsulPaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/consul")
    public String paymentConsul(){
        return "consul: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}

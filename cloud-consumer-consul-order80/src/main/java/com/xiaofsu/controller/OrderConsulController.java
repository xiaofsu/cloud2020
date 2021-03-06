package com.xiaofsu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author xiaoFsu
 * @Date 2020/4/28 15:45
 * @Version 1.0
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderConsulController {

    private static  final String INVOKE_URL= "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/consul")
    public String paymentInfo(){
        String forObject = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return forObject;
    }


}

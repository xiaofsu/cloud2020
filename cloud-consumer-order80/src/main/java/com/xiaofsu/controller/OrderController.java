package com.xiaofsu.controller;

import com.xiaofsu.entity.CommonResult;
import com.xiaofsu.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author xiaoFsu
 * @Date 2020/4/27 20:00
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderController {

    //现在需要去调用8001的服务，怎么去调用呢？
    //使用RestTemplate，使用http调用的封装。
    //private static final String PAYMENT_URL = "http://localhost:8001";

    //集群的情况下，不需要具体的IP和端口，需要具体的服务名称即可。
    //如果不开启 restTemplate 的负载均衡注解，会抛出不认识当前域名错误。
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

}

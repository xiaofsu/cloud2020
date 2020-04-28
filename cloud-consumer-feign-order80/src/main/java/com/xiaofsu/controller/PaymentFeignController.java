package com.xiaofsu.controller;

import com.xiaofsu.entity.CommonResult;
import com.xiaofsu.entity.Payment;
import com.xiaofsu.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author xiaoFsu
 * @Date 2020/4/28 19:26
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id){
        return paymentFeignService.selectOne(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //openfeign 底层是 ribbon，默认的超时时间为1s
        return paymentFeignService.paymentFeignTimeout();
    }

}

package com.xiaofsu.service;

import org.springframework.stereotype.Component;

/**
 * @Author xiaoFsu
 * @Date 2020/4/28 23:00
 * @Version 1.0
 */
@Component
public class PaymentService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "back paymentInfo_OK  PaymentService";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "back paymentInfo_Timeout  PaymentService";
    }
}

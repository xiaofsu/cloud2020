package com.xiaofsu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author xiaoFsu
 * @Date 2020/4/28 19:20
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients     //开启feign支持
public class OrderFeignMain80 {

    public static void main(String[] args) {

        SpringApplication.run(OrderFeignMain80.class,args);
    }

}

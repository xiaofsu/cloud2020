package com.xiaofsu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author xiaoFsu
 * @Date 2020/4/28 15:37
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulPayment8006 {

    public static void main(String[] args) {
        SpringApplication.run(ConsulPayment8006.class,args);
    }

}

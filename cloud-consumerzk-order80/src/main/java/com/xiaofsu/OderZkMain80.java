package com.xiaofsu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author xiaoFsu
 * @Date 2020/4/28 15:11
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OderZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OderZkMain80.class,args);
    }
}

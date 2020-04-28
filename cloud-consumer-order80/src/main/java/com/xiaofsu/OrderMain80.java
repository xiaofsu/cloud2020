package com.xiaofsu;

import com.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author xiaoFsu
 * @Date 2020/4/27 19:58
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
//自定义化负载均衡策略
//@RibbonClient(name="CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}

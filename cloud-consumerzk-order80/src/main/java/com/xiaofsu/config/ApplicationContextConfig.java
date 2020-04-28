package com.xiaofsu.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author xiaoFsu
 * @Date 2020/4/28 15:12
 * @Version 1.0
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced       //开启负载均衡的
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}

package com.xiaofsu.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author xiaoFsu
 * @Date 2020/4/27 20:03
 * @Version 1.0
 */
@Configuration
public class ApplicationContextConfig {

    //如果服务的提供者挂掉了之后，并不会自动剔除，而是尝试使用。

    @Bean
    @LoadBalanced //赋予负载均衡能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}

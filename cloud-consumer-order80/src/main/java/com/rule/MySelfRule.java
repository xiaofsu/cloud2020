package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author xiaoFsu
 * @Date 2020/4/28 18:08
 * @Version 1.0
 */
@Configuration
public class MySelfRule {
    @Bean
    public IRule getIRule(){
        return new RandomRule();
    }
}

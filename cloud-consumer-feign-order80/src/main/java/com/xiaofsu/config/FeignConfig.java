package com.xiaofsu.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author xiaoFsu
 * @Date 2020/4/28 19:49
 * @Version 1.0
 */
@Configuration
public class FeignConfig {

    // 修改Feign 日志的输出级别

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}

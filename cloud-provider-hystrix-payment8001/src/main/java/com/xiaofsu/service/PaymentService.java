package com.xiaofsu.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.micrometer.core.instrument.util.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author xiaoFsu
 * @Date 2020/4/28 21:34
 * @Version 1.0
 */
@Service
@Slf4j
public class PaymentService {


    public String paymentInfo_OK(Integer id){
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_OK! \t  id："+id+"!";
    }

    //  ---- 服务 降级

    //超时之后走兜底策略，进入到 服务降级方法中。
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties =
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String paymentInfo_Timeout(Integer id){
        int timeout = 2;
        //int err = 10 / 0;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        }catch (Exception e){
            e.printStackTrace();
        }
        log.info("Test Request !!!!!"+id);
        return "线程池："+Thread.currentThread().getName()+" " +
                "paymentInfo_Timeout! \t  id："+id+"! \t 耗时："+timeout;
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+" " +
                "paymentInfo_TimeoutHandler! \t  id："+id+"! \t 已被服务降级处理。 ";
    }



    //  ---- 服务 熔断


    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enable",value = "true"),
            //请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            //时间窗口期(时间范围)
            @HystrixProperty(name = "circuitBreaker.sleepWindowsInMilliseconds",value = "10000"),
            //失败率达到多少后 跳闸。
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
            //以上匹配含义为：开启断路器，10次的失败率达到了60%，则发生断路。10秒钟之后，达到半开状态，尝试恢复当前服务。
    })
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        if(id < 0){
            throw new RuntimeException("ID 不能为负数。");
        }
        String uuid = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t调用成功，订单号："+uuid;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "发生异常错误！\t id:"+id;
    }

}

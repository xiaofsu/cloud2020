package com.xiaofsu.controller;

import com.xiaofsu.entity.CommonResult;
import com.xiaofsu.entity.Payment;
import com.xiaofsu.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * (Payment)表控制层
 *
 * @author xiaoFsu
 * @since 2020-04-27 18:04:36
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {
    /**
     * 服务对象
     */
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get/{id}")
    public CommonResult selectOne(@PathVariable("id") Long id) {
        log.info(serverPort+" 启动查询服务！");
        return this.paymentService.queryById(id,serverPort);
    }


    @PostMapping("create")
    public CommonResult insert(@RequestBody Payment payment){
        log.info(serverPort+" 启动增加服务！");
        Payment insert = paymentService.insert(payment);
        log.info("插入的结果为："+insert);
        if(null != insert) {
            return new CommonResult(200, "插入数据成功！",insert);
        }else{
            return new CommonResult(500,"插入数据失败!",null);
        }
    }

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("element:   "+service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()
                    +"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public String getPaymentLB(){
        return serverPort;
    }


    @GetMapping("/feign/timeout")
    public String paymentFeignTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return serverPort;
    }

}
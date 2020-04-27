package com.xiaofsu.controller;

import com.xiaofsu.entity.CommonResult;
import com.xiaofsu.entity.Payment;
import com.xiaofsu.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
}
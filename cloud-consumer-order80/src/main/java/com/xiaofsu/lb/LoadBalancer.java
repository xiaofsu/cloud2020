package com.xiaofsu.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author xiaoFsu
 * @Date 2020/4/28 18:37
 * @Version 1.0
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}

package com.xiaofsu.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author xiaoFsu
 * @Date 2020/4/28 18:39
 * @Version 1.0
 */
@Component  //让spring扫描到
public class MyLB implements LoadBalancer {

    //表示 原子性 的类，如果使用 int i 的话，多线程情况可能会发生未知异常。
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 :current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*** 第几次访问 next: "+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}

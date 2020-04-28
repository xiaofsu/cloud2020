# Eureka

## 什么是Eureka？

服务注册中心，官网已经停止更新。

服务治理，传统的RPC调用，管理每个服务较为复杂，所以需要服务治理，管理各服务之间的依赖关系，可以实现服务调用，负载均衡，容错等，实现服务的发现与注册。



## 什么是服务注册？

Eureka采用的是CS的设计架构，每个服务使用Eureka的客户端连接到Eureka服务端并保持心跳，来保证服务的可用性。

当服务器启动时，会把当前自己服务器的信息，例如服务器的通讯地址以别名的方式注册到注册中心上，消费者或服务的提供者会以别名的形式在注册中心获取到实际的服务通讯地址，再实现本地RPC调用。



## Eureka的两个组件？

### 1：Eureka Server

每个微服务节点通过配置启动之后，会在Eureka Server中进行注册，这样Eureka中的服务注册表会将存储所有可用服务节点的信息，服务节点的信息可以再界面直观看到。

### 2：Eureka Clinet

是个Java客户端，用来简化与Eureka Server的交互，客户端具备一个内置的，使用轮询负载算法的负载均衡器。在应用启动后，会向Eureka Server发送心跳，如果Eureka Server在多个心跳周期内没有接收到某个节点的心跳，则会将该节点移除，默认为90秒。



## Eureka的pom.xml文件

```xml
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
```



## Eureka的自我保护机制

保护模式一般用于一组客户端与Eureka Server之间存在网络分区的场景下，一旦进入到保护模式，Eureka Server将会尝试保护服务注册表中的信息，不再删除服务注册表中的数据，也就是不会注销任何服务。也就是某时刻的服务不能用，Eureka Server不会立即清理，依旧会保存该服务的信息。属于CAP理论的AP分支。

如果出现以下情况，则代表进入到了保护模式。

![image.com](https://image.xiaofsu.com/20200428000204.png)



为了防止Eureka Clinet 可以正常运行，但是不能与Eureka Server网络不通的情况下，不会立刻剔除。



## Eureka 集群

没有集群的高可用，极有可能发生单点故障。所以使用Eureka的集群，实现故障容错及负载均衡。

**互相注册，相互守望。**


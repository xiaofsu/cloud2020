package xiaofsu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author xiaoFsu
 * @Date 2020/4/27 22:10
 * @Version 1.0
 */
@SpringBootApplication
//标记当前 module 为服务注册中心。
@EnableEurekaServer
public class EurekaMain7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class,args);
    }

}

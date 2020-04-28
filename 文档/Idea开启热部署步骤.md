# Idea开启热部署步骤



## 添加pom  devtools jar 包

```xml
<!--热部署-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
```

## 添加 插件

```xml
 <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <fork>true</fork>
                    <addResources>true</addResources>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

## 开启idea自动热部署功能

`File -> Settings -> Build,Execution,Deployment -> Compiler` 设置中，勾选以下：

![image-20200427185921668](https://image.xiaofsu.com/image-20200427185921668.png)



## 更改其他设置

使用快捷键：`crtl + shift + alt + /` 选择第一个：

![image-20200427190020660](https://image.xiaofsu.com/image-20200427190020660.png)

勾选如下选项：

![image-20200427190050155](https://image.xiaofsu.com/image-20200427190050155.png)



## 重启Idea

重启Idea之后，在项目启动的过程中更改代码即可自动重启。



## 仅允许在开发环境使用，禁止上传生产环境。
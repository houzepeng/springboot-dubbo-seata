package com.hzp.order;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.hzp.order.mapper")
@DubboComponentScan(basePackages = "com.hzp.order.dubbo")
@ComponentScan(basePackages={"com.hzp.order","com.hzp.common"})
public class SpringbootDubboOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboOrderApplication.class, args);
    }

}

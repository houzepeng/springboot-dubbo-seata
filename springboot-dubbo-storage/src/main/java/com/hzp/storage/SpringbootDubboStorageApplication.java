package com.hzp.storage;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.hzp.storage.mapper")
@DubboComponentScan(basePackages = "com.hzp.storage.dubbo")
@ComponentScan(basePackages={"com.hzp.storage","com.hzp.common"})
public class SpringbootDubboStorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboStorageApplication.class, args);
    }

}

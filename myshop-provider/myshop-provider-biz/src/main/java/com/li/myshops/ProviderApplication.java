package com.li.myshops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import tk.mybatis.spring.annotation.MapperScan;

//创建SpringBoot的入口类
@SpringBootApplication
@EnableDiscoveryClient
//注意此处要引用tk.mybatis的MapperScan包下的
@MapperScan("com.li.myshops.mapper")
@EnableResourceServer
@EnableFeignClients
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
    }
}

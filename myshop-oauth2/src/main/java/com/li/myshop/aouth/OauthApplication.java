package com.li.myshop.aouth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author dell
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OauthApplication {
    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class,args);
    }
}

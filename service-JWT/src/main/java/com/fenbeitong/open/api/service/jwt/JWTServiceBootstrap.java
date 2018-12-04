package com.fenbeitong.open.api.service.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * JWTServiceBootstrap
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-12-3 - 下午2:44.
 **/
@SpringBootApplication
@EnableEurekaClient
public class JWTServiceBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(JWTServiceBootstrap.class, args);
    }
}

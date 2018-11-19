package com.fenbeitong.open.api.service.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * AuthServiceBootStrap
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-19 - 下午2:52.
 **/
@SpringBootApplication
@EnableEurekaClient
public class AuthServiceBootStrap {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceBootStrap.class, args);
    }
}

package com.fenbeitong.open.api.service.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * JWTServiceBootstrap
 *
 * <p>JWT 服务
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-12-3 - 下午2:44.
 */
@SpringBootApplication
@EnableEurekaClient
public class JwtServiceBootstrap {
  public static void main(String[] args) {
    SpringApplication.run(JwtServiceBootstrap.class, args);
  }
}

package com.fenbeitong.open.api.service.jwt.support.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * DiscoveryBootStrap
 *
 * <p>注册服务
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-11-19 - 下午2:33.
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryBootStrap {
  public static void main(String[] args) {
    SpringApplication.run(DiscoveryBootStrap.class, args);
  }
}

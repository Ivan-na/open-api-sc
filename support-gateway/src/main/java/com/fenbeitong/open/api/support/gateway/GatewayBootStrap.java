package com.fenbeitong.open.api.support.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * GatewayBootStrap
 *
 * <p>网关服务
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-11-19 - 下午2:23.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayBootStrap {

  public static void main(String[] args) {
    SpringApplication.run(GatewayBootStrap.class, args);
  }
}

package com.fenbeitong.open.api.service.jwt.edge.sass.approve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * SaasEdgeBootStrap
 *
 * <p>TODO
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-11-19 - 下午7:50.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SaasEdgeBootStrap {
    public static void main(String[] args) {
        SpringApplication.run(SaasEdgeBootStrap.class, args);
    }
}

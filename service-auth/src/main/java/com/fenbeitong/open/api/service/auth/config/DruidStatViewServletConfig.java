package com.fenbeitong.open.api.service.auth.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * DruidStatViewServletConfig
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-19 - 下午3:45.
 **/
@SpringBootConfiguration
public class DruidStatViewServletConfig {

    private final DruidConfig druidConfig;

    @Autowired
    public DruidStatViewServletConfig(DruidConfig druidConfig) {
        this.druidConfig = druidConfig;
    }

    @Bean
    public ServletRegistrationBean<StatViewServlet> druidStatViewServlet() {
        ServletRegistrationBean<StatViewServlet> srb = new ServletRegistrationBean<StatViewServlet>(
                new StatViewServlet(), druidConfig.getDruidRegistrationUrl());
        srb.addInitParameter("resetEnalbe", String.valueOf(druidConfig.isResetEnable()));
        srb.addInitParameter("loginUsername", druidConfig.getLoginUsername());
        srb.addInitParameter("loginPassword", druidConfig.getLoginPassword());

        return srb;
    }
}

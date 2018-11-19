package com.fenbeitong.open.api.service.auth.config;

import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * DruidWebStatFilterConfig
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-19 - 下午3:47.
 **/
@SpringBootConfiguration
public class DruidWebStatFilterConfig {

    private final DruidConfig druidConfig;

    @Autowired
    public DruidWebStatFilterConfig(DruidConfig druidConfig) {
        this.druidConfig = druidConfig;
    }

    @Bean
    public FilterRegistrationBean<WebStatFilter> druidWebStatFilter() {
        FilterRegistrationBean<WebStatFilter> frb = new FilterRegistrationBean<WebStatFilter>(new WebStatFilter());
        frb.addInitParameter("filtersUrlPatterns", druidConfig.getFiltersUrlPatterns());
        frb.addInitParameter("exclusions", druidConfig.getExclusions());
        frb.addInitParameter("sessionStatMaxCount", String.valueOf(druidConfig.getSessionStatMaxCount()));
        frb.addInitParameter("sessionStatEnable", String.valueOf(druidConfig.isSessionStatEnable()));
        frb.addInitParameter("principalSessionName", druidConfig.getPrincipalSessionName());
        frb.addInitParameter("profileEnable", String.valueOf(druidConfig.isProfileEnable()));

        return frb;
    }
}

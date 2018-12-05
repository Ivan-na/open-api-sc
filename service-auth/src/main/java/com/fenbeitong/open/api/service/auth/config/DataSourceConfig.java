package com.fenbeitong.open.api.service.auth.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * DataSourceConfig
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-19 - 下午3:41.
 **/
@SpringBootConfiguration
public class DataSourceConfig {

    private final DruidConfig druidConfig;

    @Autowired
    public DataSourceConfig(DruidConfig druidConfig) {
        this.druidConfig = druidConfig;
    }

    @Bean
    @Primary
    public DataSource getDataSource()
            throws Exception {
        Properties properties = new Properties();
        properties.put("url", druidConfig.getUrl());
        properties.put("username", druidConfig.getUsername());
        properties.put("password", druidConfig.getPassword());
        properties.put("initialSize", String.valueOf(druidConfig.getInitialSize()));
        properties.put("minIdle", String.valueOf(druidConfig.getMinIdle()));
        properties.put("maxActive", String.valueOf(druidConfig.getMaxActive()));
        properties.put("maxWait", String.valueOf(druidConfig.getMaxWait()));
        properties.put("timeBetweenEvictionRunsMilli", String.valueOf(druidConfig.getTimeBetweenEvictionRunsMillis()));
        properties.put("minEvictableIdleTimeMillis", String.valueOf(druidConfig.getMinEvictableIdleTimeMillis()));
        properties.put("filters", druidConfig.getFilters());
        properties.put("validationQuery", druidConfig.getValidationQuery());
        properties.put("validationQueryTimeout", String.valueOf(druidConfig.getValidationQueryTimeout()));
        properties.put("testWhileIdle", String.valueOf(druidConfig.isTestWhileIdle()));
        properties.put("testOnBorrow", String.valueOf(druidConfig.isTestOnBorrow()));
        properties.put("testOnReturn", String.valueOf(druidConfig.isTestOnReturn()));
        properties.put("poolPreparedStatements", String.valueOf(druidConfig.isPoolPreparedStatements()));
        properties.put("maxPoolPreparedStatementPerConnectionSize",
                String.valueOf(druidConfig.getMaxPoolPreparedStatementPerConnectionSize()));
        properties.put("removeAbandonedTimeoutMillis", String.valueOf(druidConfig.getRemoveAbandonedTimeoutMillis()));
        properties.put("removeAbandoned", String.valueOf(druidConfig.isRemoveAbandoned()));
        properties.put("logAbandoned", String.valueOf(druidConfig.isLogAbandoned()));
        properties.put("logDifferentThread", String.valueOf(druidConfig.isLogDifferentThread()));
        properties.put("connectionProperties", druidConfig.getConnectionProperties());
        properties.put("useGlobalDataSourceStat", String.valueOf(druidConfig.isUseGlobalDataSourceStat()));
        return DruidDataSourceFactory.createDataSource(properties);
    }
}

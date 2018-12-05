package com.fenbeitong.open.api.service.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * DruidConfig
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-19 - 下午3:32.
 **/
@Component
@ConfigurationProperties(prefix = "user.druid")
@Data
public class DruidConfig {

    /**
     * Initial Parameters
     */
    private String url;
    private String username;
    private String password;
    private int initialSize;
    private int minIdle;
    private int maxActive;
    private long maxWait;
    private long timeBetweenEvictionRunsMillis;
    private long minEvictableIdleTimeMillis;
    private String filters;
    private String validationQuery;
    private int validationQueryTimeout;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;
    private long removeAbandonedTimeoutMillis;
    private boolean removeAbandoned;
    private boolean logAbandoned;
    private boolean logDifferentThread;
    private String connectionProperties;
    private boolean useGlobalDataSourceStat;

    private String druidRegistrationUrl;
    private boolean resetEnable;
    private String loginUsername = "admin";
    private String loginPassword = "12345678";

    private String filtersUrlPatterns;
    private String exclusions;
    private int sessionStatMaxCount;
    private boolean sessionStatEnable;
    private String principalSessionName;
    private boolean profileEnable;
}

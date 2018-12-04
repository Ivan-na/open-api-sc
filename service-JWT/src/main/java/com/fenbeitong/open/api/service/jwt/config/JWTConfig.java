package com.fenbeitong.open.api.service.jwt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * JWTConfig
 * <p>JWT Token Set Params</p>
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-12-3 - 下午2:56.
 **/
@Data
@Component
@ConfigurationProperties(prefix = "JWT")
public class JWTConfig {
    private String iss;
    private String sub;
    private String exp;
    private String secret;
}

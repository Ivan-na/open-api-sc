package com.fenbeitong.open.api.service.auth.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;

/**
 * TransactionConfig
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-19 - 下午4:00.
 **/
@SpringBootConfiguration
@AutoConfigureAfter(DataSourceConfig.class)
@MapperScan(basePackages = "com.fenbeitong.open.api.service.auth.dao", annotationClass = org.apache.ibatis.annotations.Mapper.class)
public class TransactionConfig {
}

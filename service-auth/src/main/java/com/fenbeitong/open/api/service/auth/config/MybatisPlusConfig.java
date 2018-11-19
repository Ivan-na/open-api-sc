package com.fenbeitong.open.api.service.auth.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * MybatisPlusConfig
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-19 - 下午3:48.
 **/
@SpringBootConfiguration
public class MybatisPlusConfig {
    /**
     * @return com.baomidou.mybatisplus.plugins.PaginationInterceptor
     * @author Created by ivan on 下午3:48 18-11-19.
     * <p>paginationInterceptor 开启分页插件
     **/
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;

    }

}

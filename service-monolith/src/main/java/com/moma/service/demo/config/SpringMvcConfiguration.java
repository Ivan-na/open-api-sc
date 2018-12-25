package com.moma.service.demo.config;

import com.moma.service.demo.filter.interceptor.DataSignatureInterceptor;
import com.moma.zoffy.handler.exception.GeneralExceptionHandler;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * SpringMvcConfiguration
 *
 * <p>Spring Mvc Setup
 *
 * @author ivan
 * @version 1.0 Created by ivan on 12/18/18 - 6:09 PM.
 */
@SpringBootConfiguration
public class SpringMvcConfiguration implements WebMvcConfigurer {
    /**
     * @param exceptionResolvers :
     * @return void
     * @author Created by ivan on 2:26 PM 12/24/18.
     * <p>Exception Handler
     */
  @Override
  public void configureHandlerExceptionResolvers(
      List<HandlerExceptionResolver> exceptionResolvers) {
    exceptionResolvers.add(new GeneralExceptionHandler());
  }

    /**
     * @return void
     * @author Created by ivan on 6:22 PM 12/24/18.
     * <p>Interceptors
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(getDataSignatureInterceptor())
                .addPathPatterns("/open/*")
                .excludePathPatterns("/open/token/request");
    }

    /**
     * @return com.moma.service.demo.filter.interceptor.DataSignatureInterceptor
     * @author Created by ivan on 6:28 PM 12/24/18.
     * <p>//For Autowire
     */
    @Bean
    DataSignatureInterceptor getDataSignatureInterceptor() {
        return new DataSignatureInterceptor();
    }
}

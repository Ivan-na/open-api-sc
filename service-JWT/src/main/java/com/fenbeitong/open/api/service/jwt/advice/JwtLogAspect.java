package com.fenbeitong.open.api.service.jwt.advice;

import com.fenbeitong.open.api.support.commons.log.LogUtils;
import com.fenbeitong.open.api.support.web.constant.WebConstant;
import com.fenbeitong.open.api.support.web.util.ApplicationUtils;
import com.fenbeitong.open.api.support.web.util.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

/**
 * JwtLogAspect
 *
 * <p>TODO
 *
 * @author ivan
 * @version 1.0 Created by ivan on 12/10/18 - 7:24 PM.
 */
@Aspect
@Slf4j
public class JwtLogAspect {
  @Pointcut("@annotation(org.springframework.web.bind.annotation.RestController)")
  public void pointCut() {}

  @AfterReturning(returning = "ret", pointcut = "pointCut()")
  public void doAfterRuturing(Object ret) {
    HttpServletRequest request = ApplicationUtils.getRequest();
    LogUtils.printLog((Long)   request.getAttribute(WebConstant.API_BEGIN_TIME),
            request.getAttribute(WebConstant.API_UID),
            request.getParameterMap(),
            RequestUtils.getRequestBody(request),
            (String) request.getAttribute(WebConstant.API_REQURL),
            (String) request.getAttribute(WebConstant.API_MAPPING),
            (String) request.getAttribute(WebConstant.API_METHOD),
            RequestUtils.getIpAddr(request),
            ret);
  }

}

package com.fenbeitong.open.api.support.web.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ApplicationContextRegister
 *
 * <p>TODO
 *
 * @author ivan
 * @version 1.0 Created by ivan on 12/10/18 - 7:34 PM.
 */
@Component
public class ApplicationContextRegister implements ApplicationContextAware {
  private static ApplicationContext APPLICATION_CONTEXT;

  static ApplicationContext getApplicationContext() {
    return APPLICATION_CONTEXT;
  }

  /**
   * 设置spring上下文
   *
   * @param applicationContext spring上下文
   * @throws BeansException
   */
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    APPLICATION_CONTEXT = applicationContext;
  }
}

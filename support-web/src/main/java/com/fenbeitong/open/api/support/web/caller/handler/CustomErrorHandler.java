package com.fenbeitong.open.api.support.web.caller.handler;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

/**
 * CustomErrorHandler
 *
 * <p>自定义错误处理 //TODO 待完成
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-11-29 - 上午11:37.
 */
public class CustomErrorHandler implements ResponseErrorHandler {
  /**
   * @param response :
   * @return boolean
   * @author Created by ivan on 下午8:57 18-11-22.
   *     <p>//TODO 错误发现待完成
   * @see
   *     org.springframework.web.client.ResponseErrorHandler#hasError(org.springframework.http.client.ClientHttpResponse)
   */
  @Override
  public boolean hasError(ClientHttpResponse response) {
    return false;
  }

  /**
   * @param response :
   * @author Created by ivan on 下午8:57 18-11-22.
   *     <p>//TODO 错误处理待完成
   * @see
   *     org.springframework.web.client.ResponseErrorHandler#handleError(org.springframework.http.client.ClientHttpResponse)
   */
  @Override
  public void handleError(ClientHttpResponse response) {}
}

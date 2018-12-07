package com.fenbeitong.open.api.support.web.base;

import com.fenbeitong.open.api.support.web.model.dto.response.OpenApiResponse;

/**
 * BaseApi
 *
 * <p>API 基础类
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-12-7 - 下午5:31.
 */
public class BaseApi {
  /**
   * @author Created by ivan on 下午6:30 18-12-7.
   *     <p>正确返回
   * @param object :
   * @return com.fenbeitong.open.api.support.web.model.dto.response.OpenApiResponse<T>
   */
  public static <T> OpenApiResponse<T> success(T object) {
    return OpenApiResponse.success(object);
  }

  /**
   * *
   *
   * @author Created by ivan on 下午5:35 18-12-7.
   *     <p>空返回
   * @return com.fenbeitong.open.api.support.web.model.dto.response.OpenApiResponse<java.lang.Void>
   */
  public static OpenApiResponse<Void> empty() {
    return OpenApiResponse.empty();
  }
}

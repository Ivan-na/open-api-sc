package com.fenbeitong.open.api.support.web.model.dto.response;

import com.fenbeitong.open.api.support.web.emuns.ResponseCode;
import com.fenbeitong.open.api.support.web.emuns.ResponseCodeEnum;
import com.fenbeitong.open.api.support.web.handler.exception.util.ExceptionResponseUtil;

import java.time.LocalDateTime;

/**
 * ApiResponse
 *
 * <p>客户端响应返回统一出口
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-12-6 - 下午8:28.
 */
public class OpenApiResponse<T> implements java.io.Serializable {

  private static final long serialVersionUID = -467317048623810531L;
  /**
   * @author Created by ivan on 下午6:37 18-12-7.
   *     <p>空数据返回，如DELETE
   * @return com.fenbeitong.open.api.support.web.model.dto.response.OpenApiResponse<java.lang.Void>
   */
  public static OpenApiResponse<Void> empty() {
    return SuccessResponse.<Void>builder().responseCode(ResponseCodeEnum.OK.code()).build();
  }

  /**
   * @author Created by ivan on 下午6:37 18-12-7.
   *     <p>成功时返回
   * @param responseData :
   * @return com.fenbeitong.open.api.support.web.model.dto.response.OpenApiResponse<T>
   */
  public static <T> OpenApiResponse<T> success(T responseData) {
    return SuccessResponse.<T>builder()
        .responseCode(ResponseCodeEnum.OK.code())
        .responseData(responseData)
        .build();
  }

  /**
   * @author Created by ivan on 下午6:38 18-12-7.
   *     <p>失败/有异常时返回
   * @param responseContent :
   * @param exception :
   * @return com.fenbeitong.open.api.support.web.model.dto.response.OpenApiResponse<T>
   */
  public static OpenApiResponse failure(ResponseCode responseContent, Exception exception) {
    return FailedResponse.builder()
        .responseCode(responseContent.getCode())
        .responseError(responseContent.getName())
        .responseMsg(responseContent.getMsg())
        .responseData(ExceptionResponseUtil.formatException(exception))
        .responseTime(LocalDateTime.now())
        .build();
  }
}

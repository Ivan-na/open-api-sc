package handler.exception.domain;

import com.fenbeitong.open.api.service.jwt.support.commons.constants.ExceptionEnum;

/**
 * OpenApiException
 *
 * <p>自定义Exception消息
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-12-5 - 下午8:20.
 */
public class OpenApiException extends RuntimeException {
  private Integer code;
    /**
     * INFO 用于日志中输出相关的可追踪分析内容
     * eg，requestId，ipAddress，Class name
     */
  private String info;

  public OpenApiException(ExceptionEnum exceptionEnum) {
    super(exceptionEnum.getMsg());
    this.code = exceptionEnum.getCode();
  }

  public OpenApiException(ExceptionEnum exceptionEnum, String info) {
    super(exceptionEnum.getMsg());
    this.code = exceptionEnum.getCode();
    this.info = info;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }
}

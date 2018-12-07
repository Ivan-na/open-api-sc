package com.fenbeitong.open.api.support.web.handler.exception.domain;

import com.fenbeitong.open.api.support.web.emuns.BizResponseCodeEnum;
import com.fenbeitong.open.api.support.web.emuns.ResponseCode;

/**
 * OpenApiException
 *
 * <p>自定义业务Exception消息
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-12-5 - 下午8:20.
 */
public class OpenApiException extends RuntimeException {
  private static final long serialVersionUID = -2271510112860795321L;
  /** 业务响应编码 */
  private BizResponseCodeEnum bizResponseCodeEnum;
  /** INFO 用于日志中输出相关的可追踪分析内容 eg，requestId，ipAddress，Class name */
  private String info;

  public OpenApiException(BizResponseCodeEnum bizResponseCodeEnum) {
    super(bizResponseCodeEnum.msg());
    this.bizResponseCodeEnum = bizResponseCodeEnum;
  }

  public OpenApiException(BizResponseCodeEnum bizResponseCodeEnum, String info) {
    super(bizResponseCodeEnum.msg());
    this.bizResponseCodeEnum = bizResponseCodeEnum;
    this.info = info;
  }

  public String getInfo() {
    return info;
  }

  public ResponseCode getResponseCode() {
    return bizResponseCodeEnum.transform();
  }
}

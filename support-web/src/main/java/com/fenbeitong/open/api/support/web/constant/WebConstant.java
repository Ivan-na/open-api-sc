package com.fenbeitong.open.api.support.web.constant;

/**
 * WebConstants
 *
 * <p>网络相关常量值
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-12-5 - 下午6:12.
 */
public interface WebConstant {
  /** Rest Template Util 连接超时时间（秒） */
  public static final long REST_CALL_CONNECT_TIMEOUT_SECONDS = 3L;
  /** Rest Template Util 读取超时时间（秒） */
  public static final long REST_CALL_READ_TIMEOUT_SECONDS = 12L;

  /** Request */
  public static final String API_REQURL = "API_REQURL";

  public static final String API_MAPPING = "API_MAPPING";
  public static final String API_METHOD = "API_METHOD";
  public static final String API_BEGIN_TIME = "API_BEGIN_TIME";
  public static final String API_UID = "API_UID";
}

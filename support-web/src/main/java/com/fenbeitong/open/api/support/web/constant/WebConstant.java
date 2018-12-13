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
  long REST_CALL_CONNECT_TIMEOUT_SECONDS = 3L;
  /** Rest Template Util 读取超时时间（秒） */
  long REST_CALL_READ_TIMEOUT_SECONDS = 12L;

  /** Request */
  String API_REQURL = "API_REQURL";

  String API_MAPPING = "API_MAPPING";
  String API_METHOD = "API_METHOD";
  String API_BEGIN_TIME = "API_BEGIN_TIME";
  String API_UID = "API_UID";
}

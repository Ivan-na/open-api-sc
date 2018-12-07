package com.fenbeitong.open.api.support.web.emuns;

import javax.servlet.http.HttpServletResponse;

/**
 * ResponseCodeEnum
 *
 * <p>响应编码表
 *
 * <p>1.抽取常用的，用于修改部分响应信息
 *
 * <p>2.错误响应细分, TODO 后续可拆分独立业务错误响应
 *
 * @see org.springframework.http.HttpStatus
 * @see javax.servlet.http.HttpServletResponse
 * @see <a href="http://www.iana.org/assignments/http-status-codes">HTTP Status Code Registry</a>
 * @see <a href="http://en.wikipedia.org/wiki/List_of_HTTP_status_codes">List of HTTP status codes -
 *     Wikipedia</a>
 * @author ivan
 * @version 1.0 Created by ivan on 18-12-7 - 上午11:04.
 */
public enum ResponseCodeEnum {
  /** -1 */
  UNKNOWN(-1, "未知错误"),
  // 2xx Success
  /** 200 */
  OK(200, "Success"),
  /** 201 */
  CREATED(201, "Created"),
  /** 202 */
  ACCEPTED(202, "Accepted"),
  /** 203 */
  NON_AUTHORITATIVE_INFORMATION(203, "Non-Authoritative Information"),
  /** 204 */
  NO_CONTENT(204, "No Content"),
  /** 205 */
  RESET_CONTENT(205, "Reset Content"),
  // 4xx Request Error Response
  /** 400 */
  BAD_REQUEST(HttpServletResponse.SC_BAD_REQUEST, "请求参数错误或不完整"),
  /** 400 - JSON格式错误 */
  JSON_FORMAT_ERROR(HttpServletResponse.SC_BAD_REQUEST, "JSON格式错误"),
  /** 401 */
  UNAUTHORIZED(HttpServletResponse.SC_UNAUTHORIZED, "请先进行认证"),
  /** 403 */
  FORBIDDEN(HttpServletResponse.SC_FORBIDDEN, "无权查看"),
  /** 404 */
  NOT_FOUND(HttpServletResponse.SC_NOT_FOUND, "未找到该资源"),
  /** 405 */
  METHOD_NOT_ALLOWED(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "请求方式不支持"),
  /** 406 */
  NOT_ACCEPTABLE(HttpServletResponse.SC_NOT_ACCEPTABLE, "请求被拒绝"),
  /** 411 */
  LENGTH_REQUIRED(HttpServletResponse.SC_LENGTH_REQUIRED, "长度受限"),
  /** 415 */
  UNSUPPORTED_MEDIA_TYPE(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "不支持的媒体类型"),
  /** 416 */
  REQUESTED_RANGE_NOT_SATISFIABLE(
      HttpServletResponse.SC_REQUESTED_RANGE_NOT_SATISFIABLE, "不能满足请求的范围"),
  // 5xx Service Error Response
  /** 500 */
  INTERNAL_SERVER_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "接口服务错误"),
  /** 503 */
  SERVICE_UNAVAILABLE(HttpServletResponse.SC_SERVICE_UNAVAILABLE, "请求超时"),
  ;

  /** Code */
  private int code;
  /** Message */
  private String msg;

  ResponseCodeEnum(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  /**
   * @author Created by ivan on 上午11:33 18-12-7.
   *     <p>根据Code拿Msg
   * @param code :
   * @return java.lang.String
   */
  public static String getResponseCode(int code) {
    for (ResponseCodeEnum responseCodeEnum : ResponseCodeEnum.values()) {
      if (code == responseCodeEnum.code()) {
        return responseCodeEnum.msg();
      }
    }
    return ResponseCodeEnum.UNKNOWN.msg();
  }

  /**
   * @author Created by ivan on 下午6:45 18-12-7.
   *     <p>自定义消息内容转换
   * @param msg : 自定义消息
   * @return com.fenbeitong.open.api.support.web.emuns.ResponseCode
   */
  public ResponseCode transform(String msg) {
    return ResponseCode.builder().name(name()).code(code()).msg(msg).build();
  }

  /**
   * @author Created by ivan on 下午2:44 18-12-7.
   *     <p>正常转换
   * @return com.fenbeitong.open.api.support.web.emuns.ResponseCode
   */
  public ResponseCode transform() {
    return transform(msg());
  }
  /**
   * @author Created by ivan on 上午11:34 18-12-7.
   *     <p>简化获取code
   * @return int
   */
  public int code() {
    return this.code;
  }
  /**
   * @author Created by ivan on 上午11:34 18-12-7.
   *     <p>简化获取msg
   * @return java.lang.String
   */
  public String msg() {
    return this.msg;
  }
}

package com.fenbeitong.open.api.support.web.emuns;

/**
 * BizResponseCodeEnum
 *
 * <p>业务响应编码
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-12-7 - 下午3:58.
 */
public enum BizResponseCodeEnum {
  /** -1 */
  UNKNOWN(-1, "未知错误"),
  /** 1xxxx */
  APP_DATA_IS_NULL(10010, "参数未传递"),
  ;

  /** Code */
  private int code;
  /** Message */
  private String msg;

  BizResponseCodeEnum(int code, String msg) {
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
    for (BizResponseCodeEnum responseCodeEnum : BizResponseCodeEnum.values()) {
      if (code == responseCodeEnum.code()) {
        return responseCodeEnum.msg();
      }
    }
    return BizResponseCodeEnum.UNKNOWN.msg();
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
   * @author Created by ivan on 下午6:45 18-12-7.
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

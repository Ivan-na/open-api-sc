package com.fenbeitong.open.api.service.jwt.support.commons.constants;

/**
 * Exception Code Enum
 *
 * @author ivan Created by ivan on 18-12-5.
 */
public enum ExceptionEnum {
  APP_DATA_IS_NULL(10010, "参数未传递"),
  UNKNOWN(-1, "未知错误");

  private Integer code;
  private String msg;

  private ExceptionEnum(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public static String getMsg(Integer code) {
    for (ExceptionEnum ec : ExceptionEnum.values()) {
      if (code == ec.getCode()) {
        return ec.getMsg();
      }
    }
    return null;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}

package com.fenbeitong.open.api.support.web.emuns;

import lombok.*;

/**
 * ResponseCode
 *
 * <p>Response Code Enum Content
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-12-7 - 上午11:21.
 */
@Getter
@ToString
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ResponseCode {

  /** Response Enum Name */
  private String name;
  /** 响应状态码 */
  private Integer code;
  /** 响应信息 */
  private String msg;
}

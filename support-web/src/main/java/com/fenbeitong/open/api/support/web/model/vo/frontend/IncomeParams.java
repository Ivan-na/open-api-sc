package com.fenbeitong.open.api.support.web.model.vo.frontend;

import com.fenbeitong.open.api.support.web.model.vo.CommonParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * IncomeParams
 *
 * <p>外部传入参数基础对象
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-11-29 - 下午4:27.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class IncomeParams<T> extends CommonParams<T> {
  private String accessToken;
  private String sign;
  private Long timestamp;
  private String employeeId;
  private String employeeType;
}

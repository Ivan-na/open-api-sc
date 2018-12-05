package model.vo.frontend;

import lombok.Data;
import lombok.EqualsAndHashCode;
import model.vo.CommonParams;

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

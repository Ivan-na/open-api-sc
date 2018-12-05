package model.vo.backend;

import lombok.Data;
import lombok.EqualsAndHashCode;
import model.vo.CommonParams;

/**
 * BizCommonParams
 *
 * <p>业务请求对象承载器
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-11-19 - 下午2:09.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BizParams<T> extends CommonParams<T> {
  private String requestId;
  private T data;
}

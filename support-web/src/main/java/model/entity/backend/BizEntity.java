package model.entity.backend;

import lombok.Data;
import lombok.EqualsAndHashCode;
import model.entity.CommonEntity;

/**
 * BizEntity
 *
 * <p>业务基础对象承载器
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-11-19 - 上午11:43.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BizEntity<T> extends CommonEntity<T> implements java.io.Serializable {
  private String requestId;
  private String code;
  private String msg;
  private String type;
  private T data;
}

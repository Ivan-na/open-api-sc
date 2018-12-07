package com.fenbeitong.open.api.support.web.model.entity.backend;

import com.fenbeitong.open.api.support.web.model.entity.CommonEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
  private static final long serialVersionUID = -8025969117272751246L;
  private String requestId;
  private String code;
  private String msg;
  private String type;
  private T data;
}

package com.fenbeitong.open.api.support.web.model.entity.backend;

import com.fenbeitong.open.api.support.web.model.entity.CommonEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * BizEntityList
 *
 * <p>业务基础数据列表承载器
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-11-29 - 上午11:16.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BizEntityList<T> extends CommonEntity<T> {
  private String requestId;
  private String code;
  private String type;
  private String msg;
  private List<T> data;
}

package com.fenbeitong.open.api.service.jwt.model.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * JwtParams
 *
 * <p>TODO
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-12-5 - 下午5:38.
 */
@Data
public class JwtParams {
  @NotEmpty(groups = JwtParams.auth.class, message = "企业ID不能为空")
  private String appId;

  @NotEmpty(groups = JwtParams.auth.class, message = "企业授权密钥不能为空")
  private String appKey;

  private String appType;

  public interface auth {
  }
}

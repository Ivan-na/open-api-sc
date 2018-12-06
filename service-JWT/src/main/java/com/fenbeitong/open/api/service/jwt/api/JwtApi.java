package com.fenbeitong.open.api.service.jwt.api;

import com.fenbeitong.open.api.service.jwt.model.vo.JwtParams;
import model.dto.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

/**
 * JWTApi
 *
 * <p>对外JWT接口
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-12-3 - 下午8:05.
 */
public class JwtApi {
  private static Logger LOGGER = LoggerFactory.getLogger(JwtApi.class);

  public ResponseData auth(@Validated JwtParams jwtParams) {

    return ResponseData.fail();
  }
}

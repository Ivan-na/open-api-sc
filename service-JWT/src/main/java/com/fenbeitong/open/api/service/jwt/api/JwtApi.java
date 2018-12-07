package com.fenbeitong.open.api.service.jwt.api;

import com.fenbeitong.open.api.service.jwt.component.JwtTokenTool;
import com.fenbeitong.open.api.service.jwt.model.dto.JwtToken;
import com.fenbeitong.open.api.service.jwt.model.vo.JwtParams;
import com.fenbeitong.open.api.support.web.base.BaseApi;
import com.fenbeitong.open.api.support.web.model.dto.response.OpenApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * JWTApi
 *
 * <p>对外JWT接口
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-12-3 - 下午8:05.
 */
@Slf4j
@RestController
@RequestMapping(value = "/open/api")
@Api(value="open-auth-info",tags = "Token")
public class JwtApi extends BaseApi {

  private final JwtTokenTool jwtTokenTool;

  @Autowired
  public JwtApi(JwtTokenTool jwtTokenTool) {
    this.jwtTokenTool = jwtTokenTool;
  }

  @PostMapping(
      value = "/token",
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ApiOperation(value = "Get List", notes = "list")
  public OpenApiResponse<JwtToken> auth(@RequestBody @Validated JwtParams jwtParams)
      throws UnsupportedEncodingException {
    JwtToken jwtToken = jwtTokenTool.genJWTToken();
    return success(jwtToken);
  }
}

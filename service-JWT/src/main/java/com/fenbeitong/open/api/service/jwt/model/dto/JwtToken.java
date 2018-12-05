package com.fenbeitong.open.api.service.jwt.model.dto;

import lombok.Data;

/**
 * JWTToken
 *
 * <p>JWT Token POJO类
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-12-3 - 下午3:52.
 */
@Data
public class JwtToken {
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }
}

package com.fenbeitong.open.api.service.jwt.model.dto;

import lombok.Data;

/**
 * JWTToken
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-12-3 - 下午3:52.
 **/
@Data
public class JWTToken {
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }
}

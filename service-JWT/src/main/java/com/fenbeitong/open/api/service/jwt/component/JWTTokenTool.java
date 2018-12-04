package com.fenbeitong.open.api.service.jwt.component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fenbeitong.open.api.service.jwt.config.JWTConfig;
import com.fenbeitong.open.api.service.jwt.model.dto.JWTToken;
import com.fenbeitong.open.api.service.jwt.support.commons.util.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWTTokenTool
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-12-3 - 下午2:50.
 **/
@Component
public class JWTTokenTool {
    private static Logger logger = LoggerFactory.getLogger(JWTTokenTool.class);

    final
    JWTConfig jwtConfig;

    @Autowired
    public JWTTokenTool(JWTConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    public JWTToken genJWTToken() throws UnsupportedEncodingException {
        return genJWTToken(new HashMap<>(0), new HashMap<>(0));
    }

    public JWTToken genJWTToken(Map<String, String> claim) throws UnsupportedEncodingException {
        return genJWTToken(new HashMap<>(0), claim);
    }

    /**
     * 生成 jwt token
     */
    public JWTToken genJWTToken(Map<String, Object> header, Map<String, String> claim) throws UnsupportedEncodingException {
        /*
         token失效时间
         */
        long exp = Long.valueOf(jwtConfig.getExp());

        Date expires = Date.from(LocalDateTime.now().plusDays(exp).atZone(ZoneId.systemDefault()).toInstant());

        JWTCreator.Builder builder;
        builder = JWT.create();
        /*自定义 PAYLOAD 信息,只能是字符串*/
        claim.forEach(builder::withClaim);
        /*添加基本信息*/
        String token = builder
                .withIssuer(jwtConfig.getIss())
                .withSubject(jwtConfig.getSub())
                .withHeader(header)
                .withExpiresAt(expires)
                .withJWTId(RandomUtils.bsonId())
                .sign(Algorithm.HMAC256(jwtConfig.getSecret()));
        return new JWTToken(token);
    }

    /**
     * 校验 jwt token
     */
    public DecodedJWT verifyToken(String token) throws UnsupportedEncodingException, JWTVerificationException {
        Algorithm algorithm = Algorithm.HMAC256(jwtConfig.getSecret());
        JWTVerifier verifier = JWT.require(algorithm).withIssuer(jwtConfig.getIss()).build();
        return verifier.verify(token);
    }
}

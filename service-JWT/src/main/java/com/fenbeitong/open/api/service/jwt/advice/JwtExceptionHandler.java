package com.fenbeitong.open.api.service.jwt.advice;

import com.fenbeitong.open.api.support.web.handler.exception.GlobalExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * JwtExceptionHandler
 *
 * <p>TODO
 *
 * @author ivan
 * @version 1.0 Created by ivan on 12/10/18 - 6:38 PM.
 */
@RestControllerAdvice(annotations = RestController.class)
public class JwtExceptionHandler extends GlobalExceptionHandler {}

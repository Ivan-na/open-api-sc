package com.fenbeitong.open.api.support.web.handler.exception.util;

import com.fenbeitong.open.api.support.web.handler.exception.domain.OpenApiException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * ExceptionUtil
 *
 * <p>Exception Tools
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-12-6 - 下午8:53.
 */
public class ExceptionResponseUtil {

  /**
   * @author Created by ivan on 下午4:27 18-12-7.
   *     <p>Format Exception with Readable String Output
   * @param exception : Exception
   * @return java.lang.String
   */
  public static String formatException(Exception exception) {
    if (null == exception) {
      return null;
    } else if (exception instanceof OpenApiException) {
      StringBuilder builder = new StringBuilder("OPEN-API 服务失败： ");
      builder
          .append("错误码：" + ((OpenApiException) exception).getResponseCode().getCode())
          .append("  失败响应信息：" + ((OpenApiException) exception).getResponseCode().getMsg());
      builder
          .append("  附加信息：" + ((OpenApiException) exception).getInfo())
          .append("  发生时间：" + LocalDateTime.now());
      return builder.toString();
    } else if (exception instanceof MethodArgumentNotValidException) {
      StringBuilder builder = new StringBuilder("校验失败:");
      List<ObjectError> allErrors =
          ((MethodArgumentNotValidException) exception).getBindingResult().getAllErrors();
      allErrors
          .stream()
          .findFirst()
          .ifPresent(
              error -> {
                builder
                    .append(((FieldError) error).getField())
                    .append("字段规则为")
                    .append(error.getDefaultMessage());
              });
      return builder.toString();
    } else if (exception instanceof MissingServletRequestParameterException) {
      StringBuilder builder = new StringBuilder("参数字段");
      MissingServletRequestParameterException ex =
          (MissingServletRequestParameterException) exception;
      builder.append(ex.getParameterName());
      builder.append("校验不通过");
      return builder.toString();
    } else if (exception instanceof MissingPathVariableException) {
      StringBuilder builder = new StringBuilder("路径字段");
      MissingPathVariableException ex = (MissingPathVariableException) exception;
      builder.append(ex.getVariableName());
      builder.append("校验不通过");
      return builder.toString();
    } else if (exception instanceof ConstraintViolationException) {
      StringBuilder builder = new StringBuilder("方法.参数字段");
      ConstraintViolationException ex = (ConstraintViolationException) exception;
      Optional<ConstraintViolation<?>> first = ex.getConstraintViolations().stream().findFirst();
      if (first.isPresent()) {
        ConstraintViolation<?> constraintViolation = first.get();
        builder.append(constraintViolation.getPropertyPath().toString());
        builder.append("校验不通过");
      }
      return builder.toString();
    }
    return exception.toString();
  }
}

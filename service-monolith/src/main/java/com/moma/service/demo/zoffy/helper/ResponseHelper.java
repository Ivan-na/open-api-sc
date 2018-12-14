package com.moma.service.demo.zoffy.helper;

import com.moma.service.demo.zoffy.response.dto.FailedResponse;
import com.moma.service.demo.zoffy.response.dto.HttpStatusInfo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * ResponseHelper
 *
 * <p>TODO
 *
 * @author ivan
 * @version 1.0 Created by ivan on 12/14/18 - 5:48 PM.
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseHelper {

    public static FailedResponse buildFailedResponse(
            Exception exception, HttpStatusInfo httpStatusInfo) {
        FailedResponse.FailedResponseBuilder builder = FailedResponse.builder();
        if (Objects.nonNull(httpStatusInfo)) {
            builder.code(httpStatusInfo.getCode()).msg(httpStatusInfo.getMsg());
        }
        if (Objects.nonNull(exception)) {
            builder.errorMsg(formatException(exception));
        }
        builder.time(LocalDateTime.now());
        return builder.build();
    }

    public static String formatException(Exception exception) {
        if (null == exception) {
            return null;
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

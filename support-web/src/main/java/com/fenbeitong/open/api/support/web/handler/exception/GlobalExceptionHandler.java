package com.fenbeitong.open.api.support.web.handler.exception;

import com.fasterxml.jackson.core.JsonParseException;
import com.fenbeitong.open.api.support.web.emuns.ResponseCodeEnum;
import com.fenbeitong.open.api.support.web.handler.exception.domain.OpenApiException;
import com.fenbeitong.open.api.support.web.model.dto.response.OpenApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;

/**
 * ExceptionHandler
 *
 * <p>Exception 统一处理
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-12-5 - 下午7:55.
 */
@Slf4j
public class GlobalExceptionHandler {

  /**
   * @author Created by ivan on 下午6:36 18-12-7.
   *     <p>拦截处理Exception，返回json结果 *
   *     <p>code,msg为实际返回json内容
   * @param exception :
   * @return com.fenbeitong.open.api.support.web.model.dto.response.OpenApiResponse
   */
  @ExceptionHandler(value = Exception.class)
  public OpenApiResponse exceptionHandler(
      HttpServletRequest request, HttpServletResponse response, Exception exception) {
    if (exception instanceof OpenApiException) {
      return handleOpenApiException((OpenApiException) exception);
    } else if (exception instanceof MissingPathVariableException) {
      return handleMissingPathVariableException((MissingPathVariableException) exception);
    } else if (exception instanceof MissingServletRequestParameterException) {
      return handleMissingServletRequestParameterException(
          (MissingServletRequestParameterException) exception);
    } else if (exception instanceof ServletRequestBindingException) {
      return handleServletRequestBindingException((ServletRequestBindingException) exception);
    } else if (exception instanceof ConversionNotSupportedException) {
      return handleConversionNotSupportedException((ConversionNotSupportedException) exception);
    } else if (exception instanceof TypeMismatchException) {
      return handleTypeMismatchException((TypeMismatchException) exception);
    } else if (exception instanceof HttpMessageNotReadableException) {
      return handleHttpMessageNotReadableException((HttpMessageNotReadableException) exception);
    } else if (exception instanceof MethodArgumentNotValidException) {
      return handleMethodArgumentNotValidException((MethodArgumentNotValidException) exception);
    } else if (exception instanceof MissingServletRequestPartException) {
      return handleMissingServletRequestPartException(
          (MissingServletRequestPartException) exception);
    } else if (exception instanceof BindException) {
      return handleBindException((BindException) exception);
    } else if (exception instanceof ConstraintViolationException) {
      return handleConstraintViolationException((ConstraintViolationException) exception);
    } else if (exception instanceof NoHandlerFoundException) {
      return handleNoHandlerFoundException((NoHandlerFoundException) exception);
    } else if (exception instanceof HttpRequestMethodNotSupportedException) {
      return handleHttpRequestMethodNotSupportedException(
          (HttpRequestMethodNotSupportedException) exception);
    } else if (exception instanceof HttpMediaTypeNotAcceptableException) {
      return handleHttpMediaTypeNotAcceptableException(
          (HttpMediaTypeNotAcceptableException) exception);
    } else if (exception instanceof HttpMediaTypeNotSupportedException) {
      return handleHttpMediaTypeNotSupportedException(
          (HttpMediaTypeNotSupportedException) exception);
    } else if (exception instanceof HttpMessageNotWritableException) {
      return handleHttpMessageNotWritableException((HttpMessageNotWritableException) exception);
    } else if (exception instanceof AsyncRequestTimeoutException) {
      return handleAsyncRequestTimeoutException((AsyncRequestTimeoutException) exception);
    } else {
      log.info("==========Unknown Exception Start==========");
      log.info("Exception msg  : {}", exception.getMessage());
      log.info("Exception cause  : {}", exception.getCause());
      log.info("Catch Time: {}", LocalDateTime.now());
      log.info("==========Unknown Exception end==========");
      // TODO 邮件 cause,trace
      return OpenApiResponse.failure(ResponseCodeEnum.UNKNOWN.transform(), exception);
    }
  }

  private OpenApiResponse handleOpenApiException(OpenApiException ex) {
    log.info("==========OpanApi Exception Start==========");
    log.info("Response code  : {}", ex.getResponseCode().getCode());
    log.info("Response Message  : {}", ex.getResponseCode().getMsg());
    log.info("Exception msg  : {}", ex.getMessage());
    log.info("Exception cause  : {}", ex.getCause());
    log.info("Log Info : {}", ex.getInfo());
    log.info("Catch Time: {}", LocalDateTime.now());
    log.info("==========OpenApi Exception end==========");
    return OpenApiResponse.failure(ex.getResponseCode(), ex);
  }

  /**
   * 400
   *
   * @param ex the MissingServletRequestParameterException to be handled
   */
  protected OpenApiResponse handleMissingServletRequestParameterException(
      MissingServletRequestParameterException ex) {
    return OpenApiResponse.failure(ResponseCodeEnum.BAD_REQUEST.transform(), ex);
  }

  /**
   * 400
   *
   * @param ex the exception to be handled
   */
  protected OpenApiResponse handleServletRequestBindingException(
      ServletRequestBindingException ex) {
    return OpenApiResponse.failure(ResponseCodeEnum.BAD_REQUEST.transform(), ex);
  }

  /**
   * 400
   *
   * @param ex the TypeMismatchException to be handled
   */
  protected OpenApiResponse handleTypeMismatchException(TypeMismatchException ex) {
    return OpenApiResponse.failure(ResponseCodeEnum.BAD_REQUEST.transform(), ex);
  }

  /**
   * 400
   *
   * @param ex the HttpMessageNotReadableException to be handled
   */
  protected OpenApiResponse handleHttpMessageNotReadableException(
      HttpMessageNotReadableException ex) {
    if (ex.getCause() instanceof JsonParseException) {
      return OpenApiResponse.failure(ResponseCodeEnum.JSON_FORMAT_ERROR.transform(), ex);
    } else {
      return OpenApiResponse.failure(ResponseCodeEnum.BAD_REQUEST.transform(), ex);
    }
  }

  /** 400 */
  protected OpenApiResponse handleMethodArgumentNotValidException(
      MethodArgumentNotValidException ex) {
    return OpenApiResponse.failure(ResponseCodeEnum.BAD_REQUEST.transform(), ex);
  }

  /** 400 */
  protected OpenApiResponse handleMissingServletRequestPartException(
      MissingServletRequestPartException ex) {
    return OpenApiResponse.failure(ResponseCodeEnum.BAD_REQUEST.transform(), ex);
  }

  /** 400 */
  protected OpenApiResponse handleBindException(BindException ex) {
    return OpenApiResponse.failure(ResponseCodeEnum.BAD_REQUEST.transform(), ex);
  }

  /**
   * 400
   *
   * @param ex the {@link ConstraintViolationException }to be handled
   */
  protected OpenApiResponse handleConstraintViolationException(ConstraintViolationException ex) {
    return OpenApiResponse.failure(ResponseCodeEnum.BAD_REQUEST.transform(), ex);
  }
  /**
   * 404
   *
   * @param ex the NoHandlerFoundException to be handled
   */
  protected OpenApiResponse handleNoHandlerFoundException(NoHandlerFoundException ex) {
    return OpenApiResponse.failure(ResponseCodeEnum.NOT_FOUND.transform(), ex);
  }
  /**
   * 405
   *
   * @param ex the HttpRequestMethodNotSupportedException to be handled
   */
  protected OpenApiResponse handleHttpRequestMethodNotSupportedException(
      HttpRequestMethodNotSupportedException ex) {
    return OpenApiResponse.failure(ResponseCodeEnum.METHOD_NOT_ALLOWED.transform(), ex);
  }
  /**
   * 406
   *
   * @param ex the HttpMediaTypeNotAcceptableException to be handled
   */
  protected OpenApiResponse handleHttpMediaTypeNotAcceptableException(
      HttpMediaTypeNotAcceptableException ex) {
    return OpenApiResponse.failure(ResponseCodeEnum.NOT_ACCEPTABLE.transform(), ex);
  }

  /**
   * 415
   *
   * @param ex the HttpMediaTypeNotSupportedException to be handled
   */
  protected OpenApiResponse handleHttpMediaTypeNotSupportedException(
      HttpMediaTypeNotSupportedException ex) {
    return OpenApiResponse.failure(ResponseCodeEnum.UNSUPPORTED_MEDIA_TYPE.transform(), ex);
  }

  /**
   * 500
   *
   * @param ex the HttpMessageNotWritableException to be handled
   */
  protected OpenApiResponse handleHttpMessageNotWritableException(
      HttpMessageNotWritableException ex) {
    return OpenApiResponse.failure(ResponseCodeEnum.INTERNAL_SERVER_ERROR.transform(), ex);
  }

  /**
   * 500
   *
   * @param ex the ConversionNotSupportedException to be handled
   */
  protected OpenApiResponse handleConversionNotSupportedException(
      ConversionNotSupportedException ex) {
    return OpenApiResponse.failure(ResponseCodeEnum.INTERNAL_SERVER_ERROR.transform(), ex);
  }
  /**
   * 500
   *
   * @param ex the MissingPathVariableException to be handled
   */
  protected OpenApiResponse handleMissingPathVariableException(MissingPathVariableException ex) {
    return OpenApiResponse.failure(ResponseCodeEnum.INTERNAL_SERVER_ERROR.transform(), ex);
  }

  /**
   * 503
   *
   * @param ex the {@link AsyncRequestTimeoutException }to be handled
   */
  protected OpenApiResponse handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex) {
    return OpenApiResponse.failure(ResponseCodeEnum.SERVICE_UNAVAILABLE.transform(), ex);
  }
}

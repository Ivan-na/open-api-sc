package handler.exception;

import com.fenbeitong.open.api.service.jwt.support.commons.constants.ExceptionEnum;
import com.fenbeitong.open.api.service.jwt.support.commons.util.DateHelper;
import handler.exception.domain.OpenApiException;
import model.dto.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ExceptionHandler
 *
 * <p>TODO
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-12-5 - 下午7:55.
 */
@RestControllerAdvice
public class ExceptionHandler {
  private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

  /**
   * @author Created by ivan on 下午8:54 18-12-5.
   *     <p>拦截处理Exception，返回json结果
   *     <p>code,msg为实际返回json内容
   * @param e :
   * @return model.dto.ResponseData
   */
  public ResponseData exceptionHandler(Exception e) {
    if (e instanceof OpenApiException) {
      OpenApiException openApiException = (OpenApiException) e;
      LOGGER.debug(
          "===========================OpanApi Exception Start==========================================");
      LOGGER.debug("Exception code  : {}", openApiException.getCode());
      LOGGER.debug("Exception msg  : {}", openApiException.getMessage());
      LOGGER.debug("Exception cause  : {}", openApiException.getCause());
      LOGGER.debug("Log Info : {}", openApiException.getInfo());
      LOGGER.debug("Catch Time: {}", DateHelper.getDateTime());
      LOGGER.debug(
          "===========================OpenApi Exception end=================================================");
      // TODO 邮件 cause,trace
      return ResponseData.fail(openApiException.getCode(), openApiException.getMessage());
    } else {
      LOGGER.debug(
          "===========================Unknown Exception Start==========================================");
      LOGGER.debug("Exception msg  : {}", e.getMessage());
      LOGGER.debug("Exception cause  : {}", e.getCause());
      LOGGER.debug("Catch Time: {}", DateHelper.getDateTime());
      LOGGER.debug(
          "===========================Unknown Exception end=================================================");
      // TODO 邮件 cause,trace
      return ResponseData.fail(ExceptionEnum.UNKNOWN.getCode(), ExceptionEnum.UNKNOWN.getMsg());
    }
  }
}

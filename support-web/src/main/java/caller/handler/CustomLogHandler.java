package caller.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Optional;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.util.StreamUtils.copyToByteArray;

/**
 * CustomLogHandler
 *
 * <p>Log interceptor for rest template caller
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-11-29 - 下午2:45.
 */
public class CustomLogHandler implements ClientHttpRequestInterceptor {
  private static final Logger LOGGER = LoggerFactory.getLogger(CustomLogHandler.class);

  private static final Charset DEFAULT_CHARSET = UTF_8;

  /**
   * @param request :
   * @param body :
   * @param charset :
   * @author Created by ivan on 下午3:40 18-11-29.
   *     <p>//logRequest
   */
  private static long logRequest(HttpRequest request, byte[] body, Charset charset) {
    long startTime = System.currentTimeMillis();
    LOGGER.debug(
        "===========================request begin================================================");
    LOGGER.debug("URI         : {}", request.getURI());
    LOGGER.debug("Method      : {}", request.getMethod());
    LOGGER.debug("Headers     : {}", request.getHeaders());
    LOGGER.debug("Request body: {}", new String(body, charset));
    LOGGER.debug("Start Time: {}", startTime);
    LOGGER.debug(
        "===========================request end================================================");
    return startTime;
  }

  /**
   * @param response :
   * @param charset :
   * @author Created by ivan on 下午3:40 18-11-29.
   *     <p>// logResponse
   */
  private static void logResponse(ClientHttpResponse response, Charset charset, long startTime)
      throws IOException {
    long finishTime = System.currentTimeMillis();
    long costTime = finishTime - startTime;
    LOGGER.debug(
        "===========================response begin==========================================");
    LOGGER.debug("Status code  : {}", response.getStatusCode());
    LOGGER.debug("Status text  : {}", response.getStatusText());
    LOGGER.debug("Headers      : {}", response.getHeaders());
    LOGGER.debug("Response body: {}", new String(copyToByteArray(response.getBody()), charset));
    LOGGER.debug("Finish Time: {}", finishTime);
    LOGGER.debug("Cost Time: {}", costTime);
    LOGGER.debug(
        "===========================response end=================================================");
  }

  /**
   * @param httpRequest :
   * @param body :
   * @param clientHttpRequestExecution :
   * @return org.springframework.http.client.ClientHttpResponse
   * @author Created by ivan on 下午3:40 18-11-29.
   *     <p>//intercept
   */
  @Override
  public ClientHttpResponse intercept(
      HttpRequest httpRequest, byte[] body, ClientHttpRequestExecution clientHttpRequestExecution)
      throws IOException {
    long startTime = logRequest(httpRequest, body, getCharset(httpRequest));
    ClientHttpResponse httpResponse = clientHttpRequestExecution.execute(httpRequest, body);
    logResponse(httpResponse, getCharset(httpRequest), startTime);
    return httpResponse;
  }

  /**
   * @param message :
   * @return java.nio.charset.Charset
   * @author Created by ivan on 下午3:40 18-11-29.
   *     <p>// getCharset
   */
  private Charset getCharset(HttpMessage message) {
    return Optional.ofNullable(message.getHeaders().getContentType())
        .map(MediaType::getCharset)
        .orElse(DEFAULT_CHARSET);
  }
}

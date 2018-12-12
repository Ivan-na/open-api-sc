package com.fenbeitong.open.api.support.commons.log;

import com.fenbeitong.open.api.support.commons.log.dto.Log;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;

/**
 * LogUtils
 *
 * <p>TODO
 *
 * @author ivan
 * @version 1.0 Created by ivan on 12/10/18 - 7:37 PM.
 */
@Slf4j
public class LogUtils {
  public static void printLog(
      Long beginTime,
      Object uid,
      Map<String, String[]> parameterMap,
      String requestBody,
      String url,
      String mapping,
      String method,
      String ip,
      Object object) {

    Gson gson = new Gson();
    Log logInfo =
        Log.builder()
            // 查询参数
            .parameterMap(parameterMap)
            .uid(null == uid ? null : uid.toString())
            // 请求体
            .requestBody(
                Optional.ofNullable(gson.fromJson(requestBody, Object.class)).orElse(requestBody))
            // 请求路径
            .url(url)
            // 请求mapping
            .mapping(mapping)
            // 请求方法
            .method(method)
            .runTime((beginTime != null ? System.currentTimeMillis() - beginTime : 0) + "ms")
            .result(object)
            .ip(ip)
            .build();
    log.info(gson.toJson(logInfo));
  }
}

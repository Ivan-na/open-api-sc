package com.moma.service.demo.zoffy.helper;

import com.moma.service.demo.zoffy.model.pojo.RequestLogInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;

/**
 * LogHelper
 *
 * <p>Log Helper
 *
 * @author ivan
 * @version 1.0 Created by ivan on 12/13/18 - 4:45 PM.
 */
@Slf4j
public abstract class LogHelper {
    /**
     * @param requestId    :
     * @param parameterMap :
     * @param requestBody  :
     * @param url          :
     * @param mapping      :
     * @param method       :
     * @param result       :
     * @param runTime      :
     * @param ip           :
     * @param uid          :
     * @author Created by ivan on 5:55 PM 12/13/18.
     * <p>print Request Log Info </p>
     **/
    public static void printRequestLogInfo(
            String requestId,
            Map<String, String[]> parameterMap,
            String requestBody,
            String url,
            String mapping,
            String method,
            Object result,
            String runTime,
            String ip,
            String uid) {

        RequestLogInfo requestLogInfo =
                RequestLogInfo.builder()
                        .requestId(requestId)
                        .ip(ip)
                        .mapping(mapping)
                        .method(method)
                        .parameterMap(parameterMap)
                        .requestBody(Optional.ofNullable(JacksonHelper.parse(requestBody)).orElse(requestBody))
                        .result(result)
                        .runTime(runTime)
                        .url(url)
                        .uid(uid)
                        .build();

        log.info(JacksonHelper.toJson(requestLogInfo));
    }
}


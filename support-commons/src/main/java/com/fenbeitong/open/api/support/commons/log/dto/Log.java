package com.fenbeitong.open.api.support.commons.log.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

/**
 * Log
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 12/10/18 - 7:40 PM.
 **/
@Getter
@ToString
@Builder
@EqualsAndHashCode(callSuper = false)
public class Log {
    /**
     * 参数
     */
    private Map<String, String[]> parameterMap;
    /**
     * requestBody
     */
    private Object requestBody;
    /**
     * 请求路径
     */
    private String url;
    /**
     * 请求mapping
     */
    private String mapping;
    /**
     * 请求方法
     */
    private String method;
    /**
     * 日志需要打印的json字符串
     */
    private Object result;
    /**
     * 接口运行时间 单位:ms
     */
    private String runTime;
    /**
     * IP地址
     */
    private String ip;
    /**
     * UID
     */
    private String uid;
}

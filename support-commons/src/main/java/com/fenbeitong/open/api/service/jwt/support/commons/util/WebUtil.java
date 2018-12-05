package com.fenbeitong.open.api.service.jwt.support.commons.util;

import java.util.Map;
import java.util.Set;

/**
 * WebUtil
 *
 * <p>WEB常用工具类
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-11-29 - 下午6:52.
 */
public class WebUtil {
    private static final String URL_PATH_QUERY_MARK = "?";
    private static final String URL_PATH_QUERY_DELIMITER = "&";

    /**
     * @param url        : 原始请求路径
     * @param pathParams : 路径参数
     * @return java.lang.String : 合并后路径
     * @author Created by ivan on 下午5:11 18-11-29.
     * <p>拼接请求路径参数
     */
    public static String expandUrl(String url, Map<String, String> pathParams) {
        boolean isFirst = true;
        if (url.contains(URL_PATH_QUERY_MARK)) {
            isFirst = false;
        }
        StringBuilder urlSb = new StringBuilder(url);
        Set<String> keySet = pathParams.keySet();
        for (String key : keySet) {
            if (isFirst) {
                urlSb.append(URL_PATH_QUERY_MARK);
            } else {
                urlSb.append(URL_PATH_QUERY_DELIMITER);
            }
            urlSb.append(key).append("=").append(pathParams.get(key));
        }
        return urlSb.toString();
    }
}

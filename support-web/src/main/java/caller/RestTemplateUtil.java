package caller;

import caller.handler.CustomErrorHandler;
import caller.handler.CustomLogHandler;
import com.fenbeitong.open.api.service.jwt.support.commons.constants.SysConstants;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Set;

/**
 * RestTemplateUtil
 *
 * <p>RestTemplate Util
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-11-29 - 上午11:36.
 */
public class RestTemplateUtil {
    /**
     * @param url             : 请求URL
     * @param returnClassName : 返回映射对象类型
     * @param parameters      : 站位符替换参数map
     * @return T
     * @author Created by ivan on 下午3:49 18-11-22.
     * <p>Get 请求
     */
    public static <T> T get(String url, Class<T> returnClassName, Map<String, String> parameters) {
        RestTemplate restTemplate =
                new RestTemplateBuilder()
                        .additionalInterceptors(new CustomLogHandler())
                        .errorHandler(new CustomErrorHandler())
                        .build();
        if (null == parameters || parameters.isEmpty()) {
            return restTemplate.getForObject(url, returnClassName);
        }
        return restTemplate.getForObject(url, returnClassName, parameters);
    }

    /**
     * @param url             : 请求URL
     * @param returnClassName : 返回映射对象类型
     * @param inputHeader     : 请求自定义header
     * @param formParameter   : 提交参数
     * @return T
     * @author Created by ivan on 下午3:49 18-11-22.
     * <p>form提交，json返回的post请求
     */
    public static <T> T post(
            String url,
            Class<T> returnClassName,
            Map<String, String> inputHeader,
            LinkedMultiValueMap<String, String> formParameter) {
        RestTemplate restTemplate =
                new RestTemplateBuilder()
                        .additionalInterceptors(new CustomLogHandler())
                        .errorHandler(new CustomErrorHandler())
                        .build();
        // 请求Header
        HttpHeaders httpHeaders = new HttpHeaders();
        // 添加Header
        if (null != inputHeader && !inputHeader.isEmpty()) {
            Set<String> keys = inputHeader.keySet();
            for (String key : keys) {
                httpHeaders.add(key, inputHeader.get(key));
            }
        }
        // 设置请求的类型及编码
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.add(SysConstants.HTTP_HEADER_ACCEPT, MediaType.APPLICATION_JSON.toString());
        // 发送请求
        HttpEntity<LinkedMultiValueMap<String, String>> formEntity =
                new HttpEntity<>(formParameter, httpHeaders);
        return restTemplate.postForObject(url, formEntity, returnClassName);
    }

    /**
     * @param url             :
     * @param returnClassName :
     * @param inputHeader     :
     * @param jsonData        :
     * @author Created by ivan on 下午3:49 18-11-22.
     * <p>json提交，json返回
     */
    public static <T> T post(
            String url, Class<T> returnClassName, Map<String, String> inputHeader, String jsonData) {
        RestTemplate restTemplate =
                new RestTemplateBuilder()
                        .additionalInterceptors(new CustomLogHandler())
                        .errorHandler(new CustomErrorHandler())
                        .build();
        // 请求Header
        HttpHeaders httpHeaders = new HttpHeaders();
        // 拼接Header
        if (null != inputHeader && !inputHeader.isEmpty()) {
            Set<String> keys = inputHeader.keySet();
            for (String key : keys) {
                httpHeaders.add(key, inputHeader.get(key));
            }
        }
        // 设置请求的类型及编码
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        httpHeaders.add(SysConstants.HTTP_HEADER_ACCEPT, MediaType.APPLICATION_JSON.toString());
        // 发送请求
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonData, httpHeaders);
        return restTemplate.postForObject(url, requestEntity, returnClassName);
    }

    /**
     * @param url             :
     * @param returnClassName :
     * @param inputHeader     :
     * @param inputParameter  :
     * @param urlVariables    :
     * @return T
     * @author Created by ivan on 下午3:50 18-11-22.
     * <p>Form数据PUT请求
     */
    public static <T> T put(
            String url,
            Class<T> returnClassName,
            Map<String, String> inputHeader,
            LinkedMultiValueMap<String, String> inputParameter,
            Map<String, String> urlVariables) {
        return exchange(
                url, HttpMethod.PUT, returnClassName, inputHeader, inputParameter, urlVariables);
    }

    /**
     * @param url             :
     * @param returnClassName :
     * @param inputHeader     :
     * @param jsonData        :
     * @param urlVariables    :
     * @return T
     * @author Created by ivan on 下午3:50 18-11-22.
     * <p>JSON数据PUT请求
     */
    public static <T> T put(
            String url,
            Class<T> returnClassName,
            Map<String, String> inputHeader,
            String jsonData,
            Map<String, String> urlVariables) {
        return exchange(url, HttpMethod.PUT, returnClassName, inputHeader, jsonData, urlVariables);
    }

    /**
     * @param url             :
     * @param returnClassName :
     * @param inputHeader     :
     * @param urlVariables    :
     * @return T
     * @author Created by ivan on 下午3:50 18-11-22.
     * <p>路径参数DELETE
     * <p>eg, http://abc.com/{id}
     */
    public static <T> T delete(
            String url,
            Class<T> returnClassName,
            Map<String, String> inputHeader,
            Map<String, String> urlVariables) {
        return exchange(url, HttpMethod.DELETE, returnClassName, inputHeader, "", urlVariables);
    }

    /**
     * @param url             :
     * @param method          :
     * @param returnClassName :
     * @param inputHeader     :
     * @param inputParameter  :
     * @param urlVariables    :
     * @return T
     * @author Created by ivan on 下午3:50 18-11-22.
     * <p>FORM数据EXCHANGE
     */
    public static <T> T exchange(
            String url,
            HttpMethod method,
            Class<T> returnClassName,
            Map<String, String> inputHeader,
            LinkedMultiValueMap<String, String> inputParameter,
            Map<String, String> urlVariables) {
        RestTemplate restTemplate =
                new RestTemplateBuilder()
                        .additionalInterceptors(new CustomLogHandler())
                        .errorHandler(new CustomErrorHandler())
                        .build();
        // 请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        // 拼接Header
        if (null != inputHeader && !inputHeader.isEmpty()) {
            Set<String> keys = inputHeader.keySet();
            for (String key : keys) {
                httpHeaders.add(key, inputHeader.get(key));
            }
        }
        // 请求体
        // 设置请求的类型及编码
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        // 发送请求
        HttpEntity<LinkedMultiValueMap<String, String>> formEntity =
                new HttpEntity<>(inputParameter, httpHeaders);
        ResponseEntity<T> resultEntity =
                restTemplate.exchange(url, method, formEntity, returnClassName, urlVariables);
        return resultEntity.getBody();
    }

    /**
     * @param url             :
     * @param method          :
     * @param returnClassName :
     * @param inputHeader     :
     * @param jsonData        :
     * @param urlVariables    :
     * @return T
     * @author Created by ivan on 下午3:51 18-11-22.
     * <p>JSON数据，exchange
     */
    public static <T> T exchange(
            String url,
            HttpMethod method,
            Class<T> returnClassName,
            Map<String, String> inputHeader,
            String jsonData,
            Map<String, String> urlVariables) {
        RestTemplate restTemplate =
                new RestTemplateBuilder()
                        .additionalInterceptors(new CustomLogHandler())
                        .errorHandler(new CustomErrorHandler())
                        .build();
        // 请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        // 拼接Header
        if (null != inputHeader && !inputHeader.isEmpty()) {
            Set<String> keys = inputHeader.keySet();
            for (String key : keys) {
                httpHeaders.add(key, inputHeader.get(key));
            }
        }
        // 请求体
        // 设置请求的类型及编码
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        // 发送请求
        HttpEntity<String> formEntity = new HttpEntity<>(jsonData, httpHeaders);
        ResponseEntity<T> resultEntity =
                restTemplate.exchange(url, method, formEntity, returnClassName, urlVariables);
        return resultEntity.getBody();
    }
}

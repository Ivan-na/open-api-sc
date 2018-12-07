package com.fenbeitong.open.api.support.web.caller;

import com.fenbeitong.open.api.support.commons.constants.SysConstants;
import com.fenbeitong.open.api.support.commons.util.ValueHelper;
import com.fenbeitong.open.api.support.commons.util.WebUtil;
import com.fenbeitong.open.api.support.web.model.entity.backend.BizEntity;
import com.fenbeitong.open.api.support.web.model.entity.backend.BizEntityList;
import com.fenbeitong.open.api.support.web.model.vo.backend.BizParams;
import com.google.common.collect.Maps;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.LinkedMultiValueMap;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * BizApiCaller
 *
 * <p>BIZ API CALLER
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-11-29 - 下午4:21.
 */
public class BizApiCaller<T, R> {
  private static final Logger LOGGER = LoggerFactory.getLogger(BizApiCaller.class);
  private FieldNamingPolicy fieldNamingPolicy = FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;

  private String[] ignores = {};

  /**
   * @author Created by ivan on 下午6:31 18-12-7.
   *     <p>Get Request
   * @param url : 请求地址
   * @param param : 请求参数对象
   * @param entity : 返回对象
   * @param parseParam : 地址中站位符替换
   * @return com.fenbeitong.open.api.support.web.model.entity.backend.BizEntity
   */
  public BizEntity getRequest(
      String url, BizParams<T> param, BizEntity<R> entity, Map<String, String> parseParam)
      throws IllegalAccessException, IntrospectionException, InvocationTargetException {
    Gson gson = new GsonBuilder().setFieldNamingPolicy(getFieldNamingPolicy()).create();
    return gson.fromJson(this.getRequest(url, param, parseParam), entity.getClass());
  }

  /**
   * @param url : 请求地址
   * @param param : 请求参数对象
   * @param entityList : 返回对象列表
   * @param parseParam : 地址中站位符替换
   * @return com.fenbeitong.open.api.support.web.model.entity.backend.BizEntityList
   * @author Created by ivan on 下午6:43 18-11-29.
   *     <p>query list request
   */
  public BizEntityList queryListRequest(
      String url, BizParams<T> param, BizEntityList<R> entityList, Map<String, String> parseParam)
      throws IllegalAccessException, IntrospectionException, InvocationTargetException {
    Gson gson = new GsonBuilder().setFieldNamingPolicy(getFieldNamingPolicy()).create();
    return gson.fromJson(this.getRequest(url, param, parseParam), entityList.getClass());
  }

  /**
   * @param url : 请求地址
   * @param param : 请求参数对象
   * @param parseParam : 地址中站位符替换
   * @return java.lang.String
   * @author Created by ivan on 下午6:45 18-11-29.
   *     <p>set get request
   */
  private String getRequest(String url, BizParams<T> param, Map<String, String> parseParam)
      throws IllegalAccessException, IntrospectionException, InvocationTargetException {
    // covert object to map
    Map<String, String> urlParameters = Maps.newHashMapWithExpectedSize(SysConstants.INIT_MAP_SIZE);
    urlParameters = ValueHelper.transBean2Map(param, urlParameters, ignores);
    // expand url
    url = WebUtil.expandUrl(url, urlParameters);
    // call
    return RestTemplateUtil.get(url, String.class, parseParam);
  }

  /**
   * @param url : 请求地址
   * @param params : 请求参数对象
   * @param entity : 返回对象
   * @param headerMap : header参数
   * @return com.fenbeitong.open.api.support.web.model.entity.backend.BizEntity
   * @author Created by ivan on 下午8:02 18-11-29.
   *     <p>基本 带HEADER，用JSON
   */
  public BizEntity postRequest(
      String url, BizParams<T> params, BizEntity<R> entity, Map<String, String> headerMap)
      throws IllegalAccessException, IntrospectionException, InvocationTargetException {
    return postRequest(url, params, entity, headerMap, true);
  }

  /**
   * @param url : 请求地址
   * @param params : 请求参数对象
   * @param entity : 返回对象
   * @param jsonFlag : 是否使用json数据
   * @return com.fenbeitong.open.api.support.web.model.entity.backend.BizEntity
   * @author Created by ivan on 下午8:02 18-11-29.
   *     <p>不带header，选择是否用json
   */
  public BizEntity postRequest(
      String url, BizParams<T> params, BizEntity<R> entity, boolean jsonFlag)
      throws IllegalAccessException, IntrospectionException, InvocationTargetException {
    return postRequest(url, params, entity, null, jsonFlag, null);
  }

  /**
   * @param url : 请求地址
   * @param params : 请求参数对象
   * @param entity : 返回对象
   * @param headerMap : header参数
   * @param jsonFlag : 是否使用json数据
   * @return com.fenbeitong.open.api.support.web.model.entity.backend.BizEntity
   * @author Created by ivan on 下午8:02 18-11-29.
   *     <p>可带header，选用json，不带额外参数
   */
  public BizEntity postRequest(
      String url,
      BizParams<T> params,
      BizEntity<R> entity,
      Map<String, String> headerMap,
      boolean jsonFlag)
      throws IllegalAccessException, IntrospectionException, InvocationTargetException {
    return postRequest(url, params, entity, headerMap, jsonFlag, null);
  }

  /**
   * @param url : 请求地址
   * @param params : 请求参数对象
   * @param entity : 返回对象
   * @param headerMap : header参数
   * @param jsonFlag : 是否使用json数据
   * @param extraMap : 使用form格式，允许对象外参数
   * @return com.fenbeitong.open.api.support.web.model.entity.backend.BizEntity
   * @author Created by ivan on 下午7:58 18-11-29.
   *     <p>可配置header，是否用json，是否有额外参数
   */
  public BizEntity postRequest(
      String url,
      BizParams<T> params,
      BizEntity<R> entity,
      Map<String, String> headerMap,
      boolean jsonFlag,
      Map<String, String> extraMap)
      throws IllegalAccessException, IntrospectionException, InvocationTargetException {
    Gson gson = new GsonBuilder().setFieldNamingPolicy(getFieldNamingPolicy()).create();
    // call
    String resultString;
    if (jsonFlag) {
      resultString = RestTemplateUtil.post(url, String.class, headerMap, gson.toJson(params));
    } else {
      // covert data object
      LinkedMultiValueMap<String, String> inputParameter =
          new LinkedMultiValueMap<>(SysConstants.INIT_MAP_SIZE);
      Map<String, String> valueMap =
          ValueHelper.transBean2Map(
              params, Maps.newHashMapWithExpectedSize(SysConstants.INIT_MAP_SIZE), ignores);
      inputParameter.setAll(valueMap);
      if (null != extraMap && !extraMap.isEmpty()) {
        inputParameter.setAll(extraMap);
      }
      resultString = RestTemplateUtil.post(url, String.class, headerMap, inputParameter);
    }
    // return
    return (gson.fromJson(resultString, entity.getClass()));
  }

  private FieldNamingPolicy getFieldNamingPolicy() {
    return fieldNamingPolicy;
  }

  public void setFieldNamingPolicy(FieldNamingPolicy fieldNamingPolicy) {
    this.fieldNamingPolicy = fieldNamingPolicy;
  }
}

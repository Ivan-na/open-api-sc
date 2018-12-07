package com.fenbeitong.open.api.support.commons.util;

import org.apache.commons.lang3.StringUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * ValueHelper 对象属性值转化MAP工具
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-11-21 - 下午7:26.
 */
public class ValueHelper {
  private static final String REFLECT = "ValueHelper : Reflect Exception";
  private static final String INSTROSPECTION = "ValueHelper : Introspection Exception";

  private ValueHelper() {
  }

  /**
   * 将List中bean的属性及属性值转化为Map对象
   *
   * @param list             对象列表
   * @param ignoreProperties 忽略的属性
   * @return List<Map                                                                                                                               <                                                                                                                               String                                                                                                                               ,                                                                                                                               String>> 属性MAP列表
   */
  public static <T> List<Map<String, String>> tranList2MapList(
          List<T> list, String[] ignoreProperties)
          throws IllegalAccessException, IntrospectionException, InvocationTargetException {
    List<Map<String, String>> resultList = new ArrayList<>(list.size());
    for (Object bean : list) {
      resultList.add(transBean2Map(bean, null, ignoreProperties));
    }
    return resultList;
  }

  /**
   * 将bean中的属性及属性值转化为Map对象，支持自定义前缀，<属性，属性值>.
   *
   * @param bean             需要转换的bean
   * @param map              存放转换后的map,若传入null则返回一个新的map
   * @param ignoreProperties 需要忽略的属性名
   * @return Map<String                                                                                                                               ,                                                                                                                               Object>
   */
  public static Map<String, String> transBean2Map(
          Object bean, Map<String, String> map, String[] ignoreProperties)
          throws IllegalAccessException, IntrospectionException, InvocationTargetException {
    return transBean2Map(bean, map, ignoreProperties, DateHelper.DATETIME_FORMAT, null, false);
  }

  /**
   * 将bean中的属性及属性值转化为Map对象，支持自定义前缀，<prefix+属性，属性值>
   *
   * @param bean             需要转换的bean
   * @param map              存放转换后的map,若传入null则返回一个新的map
   * @param ignoreProperties 需要忽略的属性名
   * @param keyPrefix        map中的键前缀
   * @return Map<String                                                                                                                               ,                                                                                                                               Object>
   */
  public static Map<String, String> transBean2Map(
          Object bean,
          Map<String, String> map,
          String[] ignoreProperties,
          String dateFormatPattern,
          String keyPrefix,
          boolean includeNull)
          throws IntrospectionException, InvocationTargetException, IllegalAccessException {
    Map<String, String> resultMap = new HashMap<>(16);
    String prefix = "";
    if (null == bean) {
      throw new IllegalArgumentException("'bean' must not be null");
    }
    if (null != map) {
      resultMap = map;
    }
    if (StringUtils.isNotBlank(keyPrefix)) {
      prefix = keyPrefix;
    }
    BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
    PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();
    for (PropertyDescriptor property : properties) {
      String key = property.getName();
      List<String> ignoreList =
              (ignoreProperties != null)
                      ? new ArrayList<>(Arrays.asList(ignoreProperties))
                      : new ArrayList<>();
      ignoreList.add("class");
      if (!ignoreList.contains(key)) {
        Method getter = property.getReadMethod();
        Object value;
        value = getter.invoke(bean);
        if (getter.getReturnType() == Date.class) {
          value = DateHelper.formatDate((Date) value, dateFormatPattern);
        }
        if (includeNull) {
          resultMap.put(prefix + key, null == value ? "" : value + "");
        } else if ((null != value && StringUtils.isNotBlank(value + ""))) {
          resultMap.put(prefix + key, value + "");
        }
      }
    }
    return resultMap;
  }
}

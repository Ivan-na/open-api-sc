package com.fenbeitong.open.api.support.web.util;

import com.fenbeitong.open.api.support.web.emuns.HttpMethodEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

/**
 * RequestUtils
 *
 * <p>TODO
 *
 * @author ivan
 * @version 1.0 Created by ivan on 12/12/18 - 7:43 PM.
 */
@Slf4j
public abstract class RequestUtils {

  /**
   * 判断请求方式GET
   *
   * @param request
   * @return
   */
  public static boolean isGet(HttpServletRequest request) {
    return HttpMethodEnum.GET.toString().equalsIgnoreCase(request.getMethod());
  }

  /**
   * 判断请求方式POST
   *
   * @param request
   * @return
   */
  public static boolean isPost(HttpServletRequest request) {
    return HttpMethodEnum.POST.toString().equalsIgnoreCase(request.getMethod());
  }

  /**
   * 判断请求方式PUT
   *
   * @param request
   * @return
   */
  public static boolean isPut(HttpServletRequest request) {
    return HttpMethodEnum.PUT.toString().equalsIgnoreCase(request.getMethod());
  }

  /**
   * 判断请求方式DELETE
   *
   * @param request
   * @return
   */
  public static boolean isDelete(HttpServletRequest request) {
    return HttpMethodEnum.DELETE.toString().equalsIgnoreCase(request.getMethod());
  }

  /**
   * 判断请求方式PATCH
   *
   * @param request
   * @return
   */
  public static boolean isPatch(HttpServletRequest request) {
    return HttpMethodEnum.PATCH.toString().equalsIgnoreCase(request.getMethod());
  }

  /**
   * 判断请求方式TRACE
   *
   * @param request
   * @return
   */
  public static boolean isTrace(HttpServletRequest request) {
    return HttpMethodEnum.TRACE.toString().equalsIgnoreCase(request.getMethod());
  }

  /**
   * 判断请求方式HEAD
   *
   * @param request
   * @return
   */
  public static boolean isHead(HttpServletRequest request) {
    return HttpMethodEnum.HEAD.toString().equalsIgnoreCase(request.getMethod());
  }

  /**
   * 判断请求方式OPTIONS
   *
   * @param request
   * @return
   */
  public static boolean isOptions(HttpServletRequest request) {
    return HttpMethodEnum.OPTIONS.toString().equalsIgnoreCase(request.getMethod());
  }

  /**
   * 获取请求
   *
   * @param request
   * @return
   */
  public static String getRequestBody(HttpServletRequest request) {
    String requestBody = null;
    if (isContainBody(request)) {
      try {
        StringWriter writer = new StringWriter();
        IOUtils.copy(request.getInputStream(), writer, StandardCharsets.UTF_8.name());
        requestBody = writer.toString();
      } catch (IOException ignored) {
      }
    }
    return requestBody;
  }

  /**
   * 获取请求
   *
   * @param request
   * @return
   */
  public static byte[] getByteBody(HttpServletRequest request) {
    byte[] body = new byte[0];
    try {
      body = StreamUtils.copyToByteArray(request.getInputStream());
    } catch (IOException e) {
      log.error("Error: Get RequestBody byte[] fail," + e);
    }
    return body;
  }

  /**
   * 是否包含请求体
   *
   * @param request
   * @return
   */
  public static boolean isContainBody(HttpServletRequest request) {
    return isPost(request) || isPut(request) || isPatch(request);
  }

  /**
   * 获取客户端的IP地址的方法是：request.getRemoteAddr()，这种方法在大部分情况下都是有效的。
   * 但是在通过了Apache,Squid等反向代理软件就不能获取到客户端的真实IP地址了，如果通过了多级反向代理的话， X-Forwarded-For的值并不止一个，而是一串IP值，
   * 究竟哪个才是真正的用户端的真实IP呢？ 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。 例如：X-Forwarded-For：192.168.1.110,
   * 192.168.1.120, 192.168.1.130, 192.168.1.100 用户真实IP为： 192.168.1.110
   *
   * @param request
   * @return
   */
  public static String getIpAddr(HttpServletRequest request) {
    // nginx代理获取的真实用户ip
    String ip = request.getHeader("X-Real-IP");
    if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("X-Forwarded-For");
    }
    if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
    }
    /*
     对于通过多个代理的情况， 第一个IP为客户端真实IP,多个IP按照','分割 "***.***.***.***".length() =
     15
    */
    if (ip != null && ip.length() > 15) {
      if (ip.indexOf(",") > 0) {
        ip = ip.substring(0, ip.indexOf(","));
      }
    }
    return ip;
  }
}

package com.moma.service.demo.filter.shiro;

import com.moma.service.demo.model.dto.auth.ResourceAuthDto;
import com.moma.service.demo.resource.service.ResourceService;
import com.moma.zoffy.constants.ApiConstants;
import com.moma.zoffy.constants.enumeration.HttpStatusCodeEnum;
import com.moma.zoffy.helper.ResponseHelper;
import com.moma.zoffy.jwtauth.JwtAuthToken;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.PathMatcher;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * JwtAuthFilter
 *
 * <p>TODO
 *
 * @author ivan
 * @version 1.0 Created by ivan on 12/15/18 - 3:36 PM.
 */
public class JwtAuthFilter extends BasicHttpAuthenticationFilter {

    private PathMatcher pathMatcher;
    private UrlPathHelper urlPathHelper;
    private ResourceService resourceService;

    @Override
    protected AuthenticationToken createToken(
            ServletRequest servletRequest, ServletResponse servletResponse) {
        // 获取请求token
        String token = getToken(WebUtils.toHttp(servletRequest));
        if (StringUtils.isBlank(token)) {
            return null;
        }
        return StringUtils.isBlank(token) ? null : new JwtAuthToken(token);
    }

    @Override
    protected boolean isAccessAllowed(
            ServletRequest request, ServletResponse response, Object mappedValue) {
        request.setAttribute(ApiConstants.REQUEST_START_TIME, System.currentTimeMillis());
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        HttpServletResponse httpResponse = WebUtils.toHttp(response);

        String token = getToken(httpRequest);
        String method = httpRequest.getMethod();
        String requestUri = urlPathHelper.getOriginatingRequestUri(httpRequest);

        request.setAttribute(ApiConstants.REQUEST_URL, requestUri);
        request.setAttribute(ApiConstants.REQUEST_METHOD, method);

        Optional<ResourceAuthDto> resourceAuthDto = null;
        //    Optional<ResourcePermDTO> optional =
        //        resourceService
        //            .getResourcePerms(method)
        //            .stream()
        //            .filter(match(method, requestUri))
        //            .findFirst();
    /*   if (resourceAuthDto.isPresent()) {
      request.setAttribute(ApiConstants.REQUEST_MEPPING, resourceAuthDto.get().getMapping());
    } else {
      httpResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
      return false;
    }
    if (Objects.isNull(token)) {
      List<ResourceAuthDto> openPerms = resourceService.getOpenPerms();
      return anyMatch(openPerms, method, requestUri);
    }
    if (isLoginRequest(request, response)) {
      if (executeLogin(request, response)) {
        String companyId = JwtTokenHelper.getCompanyId(token);
        request.setAttribute(ApiConstants.COMPANY_ID, companyId);
        List<ResourceAuthDto> perms = resourceService.getUserResourcePerms(uid);
        return anyMatch(perms, method, requestUri);
      } else {
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return sendUnauthorizedFail(request, response);
      }
    }*/
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        switch (httpResponse.getStatus()) {
            case HttpServletResponse.SC_NOT_FOUND:
                return sendNotFoundFail(request, response);
            case HttpServletResponse.SC_UNAUTHORIZED:
                return sendUnauthorizedFail(request, response);
            default:
                return sendForbiddenFail(request, response);
        }
    }

    @Override
    protected boolean onLoginFailure(
            AuthenticationToken token,
            AuthenticationException e,
            ServletRequest request,
            ServletResponse response) {
        return sendUnauthorizedFail(request, response);
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        try {
            return super.executeLogin(request, response);
        } catch (Exception ignored) {
        }
        return false;
    }

    protected String getToken(HttpServletRequest request) {

        String token = request.getHeader(AUTHORIZATION_HEADER);

        if (StringUtils.isBlank(token)) {
            token = request.getParameter(ApiConstants.ACCESS_TOKEN);
        }
        return StringUtils.isBlank(token) ? null : token.replaceFirst("Bearer ", "");
    }

    /**
     * 无权限
     */
    protected boolean sendForbiddenFail(ServletRequest request, ServletResponse response) {
        ResponseHelper.response(
                WebUtils.toHttp(request), WebUtils.toHttp(response), HttpStatusCodeEnum.FORBIDDEN);
        return false;
    }

    /**
     * 路径不存在
     */
    protected boolean sendNotFoundFail(ServletRequest request, ServletResponse response) {
        ResponseHelper.response(
                WebUtils.toHttp(request), WebUtils.toHttp(response), HttpStatusCodeEnum.NOT_FOUND);
        return false;
    }

    /**
     * 未认证
     */
    protected boolean sendUnauthorizedFail(ServletRequest request, ServletResponse response) {
        ResponseHelper.response(
                WebUtils.toHttp(request), WebUtils.toHttp(response), HttpStatusCodeEnum.UNAUTHORIZED);
        return false;
    }
}

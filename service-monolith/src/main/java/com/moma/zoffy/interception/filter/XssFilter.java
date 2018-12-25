package com.moma.zoffy.interception.filter;

import com.moma.zoffy.wapper.RequestWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * XssFilter
 *
 * <p>Xss/Request Wrapper Filter
 *
 * @author ivan
 * @version 1.0 Created by ivan on 12/13/18 - 6:13 PM.
 */
public class XssFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(
            ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        filterChain.doFilter(new RequestWrapper(req), servletResponse);
    }

    @Override
    public void destroy() {
    }
}

package com.moma.service.demo.zoffy.wapper;

import com.moma.service.demo.zoffy.response.dto.HttpStatusInfo;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * ResponseWrapper
 *
 * <p>TODO
 *
 * @author ivan
 * @version 1.0 Created by ivan on 12/14/18 - 7:51 PM.
 */
public class ResponseWrapper extends HttpServletResponseWrapper {
    private HttpStatusInfo httpStatusInfo;

    public ResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    public ResponseWrapper(HttpServletResponse response, HttpStatusInfo httpStatusInfo) {
        super(response);
    }


}

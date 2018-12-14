package com.moma.service.demo.zoffy.response;

import com.moma.service.demo.zoffy.constants.enumeration.HttpStatusCodeEnum;
import com.moma.service.demo.zoffy.helper.ResponseHelper;
import com.moma.service.demo.zoffy.response.dto.HttpStatusInfo;
import com.moma.service.demo.zoffy.response.dto.SuccessResponse;

/**
 * Response
 *
 * <p>TODO
 *
 * @author ivan
 * @version 1.0 Created by ivan on 12/14/18 - 5:10 PM.
 */
public class Response<T> implements java.io.Serializable {

    private static final long serialVersionUID = -2718986249962869007L;

    public static <T> Response<T> success(T result) {
        return SuccessResponse.<T>builder()
                .code(HttpStatusCodeEnum.OK.code())
                .msg(HttpStatusCodeEnum.OK.msg())
                .result(result)
                .build();
    }

    public static Response fail(Exception exception, HttpStatusInfo httpStatusInfo) {
        return ResponseHelper.buildFailedResponse(exception, httpStatusInfo);
    }
}

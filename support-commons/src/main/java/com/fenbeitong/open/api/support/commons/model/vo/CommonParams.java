package com.fenbeitong.open.api.support.commons.model.vo;

import lombok.Data;

/**
 * CommonParams
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-19 - 下午2:08.
 **/
@Data
public class CommonParams<T> {
    private String accessToken;
    private String sign;
    private Long timestamp;
    private String employeeId;
    private String employeeType;
}

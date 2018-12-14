package com.moma.service.demo.zoffy.response.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * HttpStatusInfo
 *
 * <p>TODO
 *
 * @author ivan
 * @version 1.0 Created by ivan on 12/14/18 - 5:37 PM.
 */
@Data
@AllArgsConstructor
@Builder
public class HttpStatusInfo {
    /**
     * Code
     */
    private int code;
    /**
     * Message
     */
    private String msg;
}

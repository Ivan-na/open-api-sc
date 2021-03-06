package com.moma.zoffy.response.dto;

import com.moma.zoffy.response.Response;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * FailedResponse
 *
 * <p>Failed Response
 *
 * @author ivan
 * @version 1.0 Created by ivan on 12/14/18 - 5:18 PM.
 */
@Getter
@ToString
@Builder
@EqualsAndHashCode(callSuper = false)
public class FailedResponse extends Response implements java.io.Serializable {

  private static final long serialVersionUID = -9037458751252134695L;
    /**
     * Response Code
     */
    private Integer code;
    /** Response Message */
  private String msg;
    /** Response Error Message */
  private String errorMsg;
    /** Response Extra Info */
  private String info;
    /** Response Time */
  private LocalDateTime time;
}

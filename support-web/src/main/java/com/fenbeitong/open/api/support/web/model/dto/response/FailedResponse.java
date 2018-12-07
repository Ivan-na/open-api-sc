package com.fenbeitong.open.api.support.web.model.dto.response;

import lombok.*;

import java.time.LocalDateTime;

/**
 * FailedResponse
 *
 * <p>Failed Response Data
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-12-6 - 下午8:29.
 */
@Getter
@ToString
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class FailedResponse extends OpenApiResponse {

  private static final long serialVersionUID = -45480054895749444L;

  /** Response CODE */
  private Integer responseCode;

  /** Response Code Name */
  private String responseError;

  /** Response MESSAGE */
  private String responseMsg;

  /** TIMESTAMP */
  private LocalDateTime responseTime;

  /** Detail Failed Data, eg. Exception */
  private String responseData;
}

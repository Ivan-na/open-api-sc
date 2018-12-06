package model.dto.response;

import lombok.*;

import java.time.LocalDateTime;

/**
 * FailedResponse
 *
 * <p>TODO
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
public class FailedResponse extends ApiResponse {

    private static final long serialVersionUID = -45480054895749444L;

    /**
     * HTTP CODE
     */
    private Integer responseCode;

    /**
     * ERROR CODE
     */
    private String responseError;

    /**
     * MESSAGE
     */
    private String responseMsg;

    /**
     * TIMESTAMP
     */
    private LocalDateTime responseTime;

    /**
     * EXCEPTION IF HAVE
     */
    private String exception;

}

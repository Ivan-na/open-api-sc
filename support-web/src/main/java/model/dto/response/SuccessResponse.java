package model.dto.response;

import lombok.*;

/**
 * SuccessResponse
 *
 * <p>Success Response Data
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
public class SuccessResponse<T> extends ApiResponse<T> {
    private static final long serialVersionUID = 3331905463023189410L;
    /**
     * HTTP CODE
     */
    private Integer responseCode;
    /**
     * RESPONSE DATA
     */
    private T responseData;
}

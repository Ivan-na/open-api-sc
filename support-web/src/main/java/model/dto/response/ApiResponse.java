package model.dto.response;

import com.fenbeitong.open.api.service.jwt.support.commons.constants.ResponseCode;

/**
 * ApiResponse
 *
 * <p>TODO
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-12-6 - 下午8:28.
 */
public class ApiResponse<T> implements java.io.Serializable {

    private static final long serialVersionUID = -467317048623810531L;

    /**
     * @return model.dto.response.ApiResponse<java.lang.Void>
     * @author Created by ivan on 下午8:42 18-12-6.
     * <p>空数据返回，如DELETE
     */
    public static ApiResponse<Void> empty() {
        return SuccessResponse.<Void>builder()
                .responseCode(ResponseCode.SUCCESS_CODE.getCode())
                .build();
    }

    public static <T> ApiResponse<T> success(T responseData) {
        return SuccessResponse.<T>builder()
                .responseCode(ResponseCode.SUCCESS_CODE.getCode())
                .responseData(responseData)
                .build();
    }

//  public static <T> ApiResponse<T> failure(){
//
//  }
}

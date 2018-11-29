package model.vo.backend;

import model.vo.CommonParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * BizCommonParams
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-19 - 下午2:09.
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class BizParams<T> extends CommonParams<T> {
    private String requestId;
    private T data;
}

package com.fenbeitong.open.api.support.commons.model.entity.backend;

import com.fenbeitong.open.api.support.commons.model.entity.CommonEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * BizCommonEntity
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-19 - 上午11:43.
 **/

@Setter
@Getter
@ToString
public class BizCommonEntity<T> extends CommonEntity<T> implements java.io.Serializable {

    private String requestId;
    private String code;
    private String msg;
    private T data;

}

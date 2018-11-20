package com.fenbeitong.open.api.edge.sass.approve.client;

import com.fenbeitong.open.api.edge.sass.approve.entity.ApproveEntity;
import com.fenbeitong.open.api.edge.sass.approve.vo.ApproveParam;
import com.fenbeitong.open.api.support.commons.model.entity.backend.BizCommonEntity;
import com.fenbeitong.open.api.support.commons.model.vo.backend.BizCommonParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * BizApproveClient
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-19 - 下午8:14.
 **/
public interface BizApproveClient {

    @PostMapping("/create")
    public BizCommonEntity<ApproveEntity> createApprove(@RequestBody BizCommonParams<ApproveParam> bizCommonParams);
}

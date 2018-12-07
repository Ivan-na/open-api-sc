package com.fenbeitong.open.api.edge.sass.approve.client.client;

import com.fenbeitong.open.api.edge.sass.approve.client.entity.ApproveEntity;
import com.fenbeitong.open.api.edge.sass.approve.client.vo.ApproveParam;
import com.fenbeitong.open.api.support.web.model.entity.backend.BizEntity;
import com.fenbeitong.open.api.support.web.model.vo.backend.BizParams;
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
    BizEntity<ApproveEntity> createApprove(@RequestBody BizParams<ApproveParam> bizParams);
}

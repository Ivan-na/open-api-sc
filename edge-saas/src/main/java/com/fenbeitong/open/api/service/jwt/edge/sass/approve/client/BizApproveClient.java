package com.fenbeitong.open.api.service.jwt.edge.sass.approve.client;

import com.fenbeitong.open.api.service.jwt.edge.sass.approve.entity.ApproveEntity;
import com.fenbeitong.open.api.service.jwt.edge.sass.approve.vo.ApproveParam;
import model.entity.backend.BizEntity;
import model.vo.backend.BizParams;
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

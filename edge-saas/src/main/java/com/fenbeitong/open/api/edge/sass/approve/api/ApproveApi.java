package com.fenbeitong.open.api.edge.sass.approve.api;

import com.fenbeitong.open.api.edge.sass.approve.entity.ApproveEntity;
import com.fenbeitong.open.api.edge.sass.approve.vo.ApproveParam;
import com.fenbeitong.open.api.support.commons.base.BaseApi;
import com.fenbeitong.open.api.support.commons.constant.ResponseCode;
import com.fenbeitong.open.api.support.commons.model.dto.ResponseData;
import com.fenbeitong.open.api.support.commons.model.entity.backend.BizCommonEntity;
import com.fenbeitong.open.api.support.commons.model.vo.backend.BizCommonParams;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static com.fenbeitong.open.api.support.commons.model.vo.backend.BizCommonParams.fromJsonWithLowerCase;
import static java.util.concurrent.Executors.*;

/**
 * ApproveApi
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-19 - 下午7:58.
 **/
@RestController
@Api("Approve Edge Service")
@Slf4j
public class ApproveApi extends BaseApi {

    public ResponseData createApprove(@RequestBody BizCommonParams<ApproveParam> bizCommonParams){
        log.info(bizCommonParams.getData().getTripList().get(0).getArrivalCityId());
        String jsonP = "{\"access_token\":\"5747fbc10f0e60e0709d8d722\",\"timestamp\":124124325,\"sign\":\"oihfnlyeofdh98\",\"employee_id\":\"59b74c1323445f2d54dd07922\",\"employee_type\":1,\"data\":{\"apply\":{\"type\":1,\"flow_type\":4, \"budget\":1,\"third_id\":\"59dc7fe62798635263b8414a\",\"third_remark\":\"approve-openapi-test2\"},\"trip_list\":[{\"type\":7,  \"start_city_id\":\"2000002\",\"start_time\":\"2017-12-13\",\"arrival_city_id\":\"1000001\",\"end_time\":\"2017-12-13\",\"estimated_amount\":1}]}}";
        bizCommonParams = fromJsonWithLowerCase(jsonP, ApproveParam.class);
        // call biz service
        Executor executor = newCachedThreadPool();
        BizCommonParams<ApproveParam>  params = bizCommonParams;
        BizCommonEntity<ApproveEntity> response = bizApproveClient.createApprove(params);

        if ("0".equals(response.getCode())) {
            return ResponseData.ok(response);
        } else {
            return ResponseData.fail(Integer.parseInt(response.getCode()), response.getMsg());
        }
    }
}

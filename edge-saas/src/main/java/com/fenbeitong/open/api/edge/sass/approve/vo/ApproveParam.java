package com.fenbeitong.open.api.edge.sass.approve.vo;

import lombok.*;

import java.util.List;

/**
 * ApproveParam
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-19 - 下午7:52.
 **/
@Data
public class ApproveParam {
    /**
     * apply : {"type":1,"flow_type":4,"budget":1,"third_id":"59dc7fe62798635263b8414a","third_remark":"approve-openapi-test2"}
     * trip_list : [{"type":7,"start_city_id":"2000002","start_time":"2017-12-13","arrival_city_id":"1000001","end_time":"2017-12-13","estimated_amount":1}]
     */

    ApplyBean apply;
    List<TripListBean> tripList;

    @Data
    public static class ApplyBean {
        /**
         * type : 1
         * flow_type : 4
         * budget : 1
         * third_id : 59dc7fe62798635263b8414a
         * third_remark : approve-openapi-test2
         */

        int type;
        int flowType;
        int budget;
        String thirdId;
        String thirdRemark;

    }

    @Data
    public static class TripListBean {
        /**
         * type : 7
         * start_city_id : 2000002
         * start_time : 2017-12-13
         * arrival_city_id : 1000001
         * end_time : 2017-12-13
         * estimated_amount : 1
         */

        int type;
        String startCityId;
        String startTime;
        String arrivalCityId;
        String endTime;
        int estimatedAmount;

    }
}

package com.fenbeitong.open.api.service.auth.api;


import com.fenbeitong.open.api.service.auth.entity.OpenAuthInfo;
import com.fenbeitong.open.api.service.auth.service.IOpenAuthInfoService;
import com.fenbeitong.open.api.support.commons.base.BaseApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import model.dto.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ivan
 * @since 2018-11-19
 */
@RestController
@RequestMapping("/auth/open-auth-info")
@Api("open-auth-info")
public class OpenAuthInfoController extends BaseApi {

    final
    private IOpenAuthInfoService openAuthInfoService;

    @Autowired
    public OpenAuthInfoController(IOpenAuthInfoService openAuthInfoService) {
        this.openAuthInfoService = openAuthInfoService;
    }

    @ApiOperation(value = "Get List", notes = "list")
    @GetMapping("/list")
    public ResponseData getList() {
        List<OpenAuthInfo> resultList = openAuthInfoService.list(null);
        if (null != resultList && 0 < resultList.size()) {
            return ResponseData.ok(resultList);
        } else {
            return ResponseData.fail();
        }
    }
}

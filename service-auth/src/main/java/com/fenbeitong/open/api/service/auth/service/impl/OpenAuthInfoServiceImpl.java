package com.fenbeitong.open.api.service.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fenbeitong.open.api.service.auth.mapper.OpenAuthInfoMapper;
import com.fenbeitong.open.api.service.auth.entity.OpenAuthInfo;
import com.fenbeitong.open.api.service.auth.service.IOpenAuthInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ivan
 * @since 2018-11-19
 */
@Service
public class OpenAuthInfoServiceImpl extends ServiceImpl<OpenAuthInfoMapper, OpenAuthInfo> implements IOpenAuthInfoService {

}

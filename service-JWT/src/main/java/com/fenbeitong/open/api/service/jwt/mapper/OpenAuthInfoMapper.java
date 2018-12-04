package com.fenbeitong.open.api.service.jwt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fenbeitong.open.api.service.jwt.model.entity.OpenAuthInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ivan
 * @since 2018-11-19
 */
@Mapper
public interface OpenAuthInfoMapper extends BaseMapper<OpenAuthInfo> {

}

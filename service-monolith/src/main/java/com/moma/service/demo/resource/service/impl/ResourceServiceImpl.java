package com.moma.service.demo.resource.service.impl;

import com.moma.service.demo.model.dto.auth.ResourceAuthDto;
import com.moma.service.demo.resource.dao.ResourceDao;
import com.moma.service.demo.resource.model.domain.Resource;
import com.moma.service.demo.resource.service.ResourceService;
import com.moma.zoffy.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现类
 *
 * @author Ivan
 * @since 2018-12-15
 */
@Service
public class ResourceServiceImpl extends BaseServiceImpl<ResourceDao, Resource>
        implements ResourceService {

    @Override
    public List<ResourceAuthDto> getAuthResources(String method) {
        return null;
    }
}

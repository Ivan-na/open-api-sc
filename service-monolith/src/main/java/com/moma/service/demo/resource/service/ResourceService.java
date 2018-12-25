package com.moma.service.demo.resource.service;

import com.moma.service.demo.model.dto.auth.ResourceAuthDto;
import com.moma.service.demo.resource.model.domain.Resource;
import com.moma.zoffy.service.BaseService;

import java.util.List;

/**
 * ResourceService
 *
 * <p>Api Resource Service Interface
 *
 * @version 1.0
 * @author Created by ivan on 2:55 PM 12/24/18.
 */
public interface ResourceService extends BaseService<Resource> {
    /**
     * @param method :
     * @return java.util.List<com.moma.service.demo.model.dto.auth.ResourceAuthDto>
     * @author Created by ivan on 4:45 PM 12/21/18.
     * <p>//Get Api Resource with Method and URL
     */
    List<ResourceAuthDto> getAuthResources(String method);

    /**
     * @return java.util.List<com.moma.service.demo.model.dto.auth.ResourceAuthDto>
     * @author Created by ivan on 4:45 PM 12/21/18.
     * <p>//Get Api Resources with OPEN TYpe
     */
    List<ResourceAuthDto> getOpenAuth();

    /**
     * @return java.util.List<com.moma.service.demo.model.dto.auth.ResourceAuthDto>
     * @author Created by ivan on 4:45 PM 12/21/18.
     * <p>//Get Api Resources with OPEN/TOKEN Type
     */
    List<ResourceAuthDto> getNonAuth();
}

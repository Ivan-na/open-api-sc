package com.moma.service.demo.zoffy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.moma.service.demo.zoffy.dao.BaseDao;
import com.moma.service.demo.zoffy.service.BaseService;

/**
 * BaseServiceImpl
 *
 * <p>Base Service Impl
 *
 * @author ivan
 * @version 1.0 Created by ivan on 12/13/18 - 7:23 PM.
 * @see com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
 */
public class BaseServiceImpl<M extends BaseDao<T>, T> extends ServiceImpl<M, T>
        implements BaseService<T> {
}

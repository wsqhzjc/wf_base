package com.wf.base.crud;

import com.wf.base.common.constants.ConfigCacheKey;
import com.wf.base.dao.BaseConfigDao;
import com.wf.base.dao.entity.BaseConfig;
import com.wf.core.service.CrudService;
import org.springframework.stereotype.Service;


/**
 * 配置项Service
 *
 * @version 2016-08-08
 */
@Service
public class BaseConfigService extends CrudService<BaseConfigDao, BaseConfig> {

    @Override
    protected void clearCache(BaseConfig entity) {
        cacheHander.delete(ConfigCacheKey.SYS_CONFIG_BY_NAME.key(entity.getName(), entity.getChannelId()));
    }

    /**
     * 根据name获取配置项
     *
     * @param name
     * @return null / BaseConfig
     */
    public BaseConfig findByName(final String name, Long channel) {
        return cacheHander.cache(ConfigCacheKey.SYS_CONFIG_BY_NAME.key(name, channel), () -> dao.findByName(name, channel));
    }
}



















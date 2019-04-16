package com.wf.base.rpc.impl;

import com.wf.base.common.constants.ChannelConstants;
import com.wf.base.crud.BaseConfigService;
import com.wf.base.dao.entity.BaseConfig;
import com.wf.base.rpc.ConfigRpcService;
import com.wf.base.rpc.dto.BaseConfigDto;
import com.wf.core.cache.CacheHander;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 配置项Service
 *
 * @version 2016-08-08
 */
@Service
public class ConfigRpcServiceRpcImpl implements ConfigRpcService {
    @Autowired
    private CacheHander cacheHander;

    @Autowired
    private BaseConfigService baseConfigService;

    /**
     * 根据name获取配置项
     *
     * @param name
     * @return null / BaseConfig
     */
    @Override
    public BaseConfigDto findByName(final String name) {
        return findByName(name, ChannelConstants.DEFAULT_CHANNEL);
    }

    @Override
    public BaseConfigDto findByName(String name, Long channel) {
        return BaseConfigDto.toDto(baseConfigService.findByName(name, channel));
    }

    /**
     * 根据name获取配置项的值
     *
     * @param name
     * @param defValue 默认值(String/int/double/float/long)
     * @return
     */
    @SuppressWarnings("unchecked")
    private <T> T getValueByName(String name, T defValue, Long channel) {
        try {
            BaseConfig config = baseConfigService.findByName(name, channel);
            if (config == null && !ChannelConstants.DEFAULT_CHANNEL.equals(channel)) {
                config = baseConfigService.findByName(name, ChannelConstants.DEFAULT_CHANNEL);
            }
            if (config == null) {
                return defValue;
            } else if (defValue instanceof Integer) {
                return (T) Integer.valueOf(config.getValue());
            } else if (defValue instanceof Double) {
                return (T) Double.valueOf(config.getValue());
            } else if (defValue instanceof Float) {
                return (T) Float.valueOf(config.getValue());
            } else if (defValue instanceof Long) {
                return (T) Long.valueOf(config.getValue());
            } else if (defValue instanceof Boolean) {
                return (T) Boolean.valueOf(config.getValue());
            } else if (defValue instanceof String) {
                return (T) config.getValue();
            } else {
                return defValue;
            }
        } catch (Exception e) {
            return defValue;
        }
    }

    /**
     * 根据name获取配置项的值
     *
     * @param name
     * @return null / BaseConfig
     */
    @Override
    public String getStringValueByName(String name) {
        return getStringValueByName(name, ChannelConstants.DEFAULT_CHANNEL);
    }

    @Override
    public String getStringValueByName(String name, Long channel) {
        return getValueByName(name, "", channel);
    }

    /**
     * 根据name获取配置项的值
     *
     * @param name
     * @return Boolean
     */
    @Override
    public boolean getBooleanValueByName(String name) {
        return getBooleanValueByName(name, ChannelConstants.DEFAULT_CHANNEL);
    }

    @Override
    public boolean getBooleanValueByName(String name, Long channel) {
        return getValueByName(name, Boolean.FALSE, channel);
    }

    /**
     * 根据name获取配置项的值
     *
     * @param name
     * @return 0d / double
     */
    @Override
    public double getDoubleValueByName(String name) {
        return getDoubleValueByName(name, ChannelConstants.DEFAULT_CHANNEL);
    }

    @Override
    public double getDoubleValueByName(String name, Long channel) {
        return getValueByName(name, 0d, channel);
    }

    /**
     * 根据name获取配置项的值
     *
     * @param name
     * @return 0 / float
     */
    @Override
    public float getFloatValueByName(String name) {
        return getFloatValueByName(name, ChannelConstants.DEFAULT_CHANNEL);
    }

    @Override
    public float getFloatValueByName(String name, Long channel) {
        return getValueByName(name, 0f, channel);
    }

    /**
     * 根据name获取配置项的值
     *
     * @param name
     * @return 0 / int
     */
    @Override
    public int getIntValueByName(String name) {
        return getIntValueByName(name, ChannelConstants.DEFAULT_CHANNEL);
    }

    @Override
    public int getIntValueByName(String name, Long channel) {
        return getValueByName(name, 0, channel);
    }

    /**
     * 根据name获取配置项的值
     *
     * @param name
     * @return 0 / long
     */
    @Override
    public long getLongValueByName(String name) {
        return getLongValueByName(name, ChannelConstants.DEFAULT_CHANNEL);
    }

    @Override
    public long getLongValueByName(String name, Long channel) {
        return getValueByName(name, 0L, channel);
    }
}



















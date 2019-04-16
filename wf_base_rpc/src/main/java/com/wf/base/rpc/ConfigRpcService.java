package com.wf.base.rpc;

import com.wf.base.rpc.dto.BaseConfigDto;

/**
 * @author chris
 */
public interface ConfigRpcService {
    /**
     * 根据name获取配置项
     *
     * @param name
     * @return null / BaseConfig
     */
    BaseConfigDto findByName(String name);

    /**
     * 根据name分渠道获取配置项
     *
     * @param name
     * @param channel
     * @return
     */
    BaseConfigDto findByName(String name, Long channel);

    /**
     * 根据name获取配置项的值
     *
     * @param name
     * @return null / BaseConfig
     */
    String getStringValueByName(String name);

    /**
     * 根据name分渠道获取配置项
     *
     * @param name
     * @param channel
     * @return
     */
    String getStringValueByName(String name, Long channel);

    /**
     * 根据name获取配置项的值
     *
     * @param name
     * @return Boolean
     */
    boolean getBooleanValueByName(String name);

    /**
     * 根据name分渠道获取配置项
     *
     * @param name
     * @param channel
     * @return
     */
    boolean getBooleanValueByName(String name, Long channel);

    /**
     * 根据name获取配置项的值
     *
     * @param name
     * @return 0d / double
     */
    double getDoubleValueByName(String name);

    /**
     * 根据name分渠道获取配置项
     *
     * @param name
     * @param channel
     * @return
     */
    double getDoubleValueByName(String name, Long channel);

    /**
     * 根据name获取配置项的值
     *
     * @param name
     * @return 0 / float
     */
    float getFloatValueByName(String name);

    /**
     * 根据name分渠道获取配置项
     *
     * @param name
     * @param channel
     * @return
     */
    float getFloatValueByName(String name, Long channel);

    /**
     * 根据name获取配置项的值
     *
     * @param name
     * @return 0 / int
     */
    int getIntValueByName(String name);

    /**
     * 根据name分渠道获取配置项
     *
     * @param name
     * @param channel
     * @return
     */
    int getIntValueByName(String name, Long channel);

    /**
     * 根据name获取配置项的值
     *
     * @param name
     * @return 0 / long
     */
    long getLongValueByName(String name);

    /**
     * 根据name分渠道获取配置项
     *
     * @param name
     * @param channel
     * @return
     */
    long getLongValueByName(String name, Long channel);
}

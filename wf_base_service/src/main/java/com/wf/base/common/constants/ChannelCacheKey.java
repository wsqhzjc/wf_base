package com.wf.base.common.constants;

import com.wf.core.cache.CacheKey;

/**
 * 交易系统账户KEY声明
 * Created by chris on 2017/10/16.
 */
public enum ChannelCacheKey implements CacheKey {
    /**
     * 渠道信息根据ID缓存
     */
    CHANNEL_INFO_BY_ID,

    /**
     * 主渠道
     */
    CHANNEL_INFO_MAIN_CHANNEL,

    /**
     * 子渠道
     */
    CHANNEL_INFO_SUB_CHANNEL,

    /**
     * 所有渠道
     */
    CHANNEL_INFO_ALL_CHANNEL;

    private final String value;

    ChannelCacheKey() {
        this.value = "BASE:CHANNEL:" + name();
    }

    @Override
    public String key() {
        return value;
    }

    public String key(Object... params) {
        StringBuilder key = new StringBuilder(value);
        if (params != null && params.length > 0) {
            for (Object param : params) {
                key.append(':');
                key.append(String.valueOf(param));
            }
        }
        return key.toString();
    }
}

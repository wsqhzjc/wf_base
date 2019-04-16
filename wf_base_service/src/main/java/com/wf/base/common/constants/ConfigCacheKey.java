package com.wf.base.common.constants;

import com.wf.core.cache.CacheKey;

/**
 * 交易系统账户KEY声明
 * Created by chris on 2017/10/16.
 */
public enum ConfigCacheKey implements CacheKey {
    /**
     * 配置项根据name字段缓存
     */
    SYS_CONFIG_BY_NAME;
    private final String value;

    ConfigCacheKey() {
        this.value = "BASE:CONFIG:" + name();
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

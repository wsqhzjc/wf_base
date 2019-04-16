package com.wf.base.common.constants;

import com.wf.core.cache.CacheKey;

/**
 * 交易系统账户KEY声明
 * Created by chris on 2017/10/16.
 */
public enum DictCacheKey implements CacheKey {
    /**
     * 字典类型列表
     */
    SYS_DICT_ALL_LIST,

    /**
     * type类型的字典集合
     */
    SYS_DICT_BY_TYPE,
    /**
     * 指定值的字典缓存
     */
    SYS_DICT_BY_VALUE,
    /**
     * 字典的value:label 键值对
     */
    SYS_DICT_BY_TYPE_MAP,
    /**
     * 字典类型type的label集合
     */
    SYS_DICT_TYPE_LABEL_LIST;
    private final String value;

    DictCacheKey() {
        this.value = "BASE:DICT:" + name();
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

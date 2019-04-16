package com.wf.base.common.constants;

import com.wf.core.cache.CacheKey;
/**
 * KEY
 * @author fxy
 * @date 2017/11/10
 */
public enum BaseCacheKey implements CacheKey {
	/**
	 * 敏感词
	 */
	SENSITIVE_CONTENT
	;
	private final String value;
	private BaseCacheKey() {
		this.value = "BASE:" + name();
	}
	@Override
	public String key() {
		return value;
	}
	
	public String key(Object...params) {
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

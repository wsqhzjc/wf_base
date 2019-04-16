package com.wf.base.common.sensitive;

import com.wf.base.common.constants.BaseCacheKey;
import com.wf.base.crud.BaseSensitiveService;
import com.wf.core.cache.CacheHander;
import com.wf.core.cache.CacheKey;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
/**
 * 敏感词初始化
 * @author fxy
 * @date 2017/11/10
 */
@Service
public class SensitiveHander implements InitializingBean {
    @Autowired
    private SensitiveWordHander sensitiveWordHander;
    @Autowired
    private BaseSensitiveService baseSensitiveService;
    @Autowired
    private CacheHander cacheHander;

    @Override
    public void afterPropertiesSet() throws Exception {
        sensitiveWordHander.init(new WordsTransfer() {
            @Override
            public Collection<String> getWords() {
                return baseSensitiveService.findAll();
            }

            @Override
            public Map<String, String> getSensitive() {
                return cacheHander.cache(BaseCacheKey.SENSITIVE_CONTENT.key(),
                        () -> sensitiveWordHander.build(), CacheKey.MONTH_3);
            }
        });
    }
}

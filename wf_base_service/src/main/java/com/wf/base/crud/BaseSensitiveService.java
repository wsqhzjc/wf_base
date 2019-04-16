package com.wf.base.crud;

import com.wf.base.common.constants.BaseCacheKey;
import com.wf.base.dao.BaseSensitiveDao;
import com.wf.base.dao.entity.BaseSensitive;
import com.wf.core.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 敏感词
 *
 * @author fxy
 * @date 2017/02/15
 */
@Service
public class BaseSensitiveService extends CrudService<BaseSensitiveDao, BaseSensitive> {
    @Override
    protected void clearCache(BaseSensitive entity) {
        super.clearCache(entity);
        cacheHander.delete(BaseCacheKey.SENSITIVE_CONTENT.key());
    }

    public List<String> findAll() {
        return dao.findAll();
    }
}



















/**
 * http://www.lbanma.com
 */
package com.wf.base.crud;

import com.wf.base.common.constants.DictCacheKey;
import com.wf.base.dao.BaseDictDao;
import com.wf.base.dao.entity.BaseDict;
import com.wf.core.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 字典Service
 *
 * @author chris
 * @version 2014-05-16
 */
@Service
public class BaseDictService extends CrudService<BaseDictDao, BaseDict> {

    /**
     * 查询字典类型列表
     *
     * @return
     */
    public List<String> findTypeList() {
        return cacheHander.cache(DictCacheKey.SYS_DICT_ALL_LIST.key(), () -> dao.findTypeList(new BaseDict()));
    }

    /**
     * 根据value获取字典项
     *
     * @param type
     * @param value
     * @return
     */
    public BaseDict getDictByValue(final String type, final int value) {
        return cacheHander.cache(DictCacheKey.SYS_DICT_BY_VALUE.key(type, value), () -> {
            BaseDict result = dao.getDictByValue(type, value);
            if (result == null) {
                logger.warn("Dict type,value = " + type + "," + value + " exception");
            }
            return result;
        });
    }

    /**
     * 获取type类型的字典列表
     *
     * @param type
     * @return
     */
    public List<BaseDict> getDictList(final String type) {
        return cacheHander.cache(DictCacheKey.SYS_DICT_BY_TYPE.key(type), () -> {
            BaseDict dict = new BaseDict();
            dict.setType(type);
            return dao.findByCond(dict);
        });
    }


    @Override
    protected void clearCache(BaseDict dict) {
        cacheHander.delete(DictCacheKey.SYS_DICT_ALL_LIST.key());
        cacheHander.delete(DictCacheKey.SYS_DICT_BY_TYPE.key(dict.getType()));
        cacheHander.delete(DictCacheKey.SYS_DICT_TYPE_LABEL_LIST.key(dict.getType()));
        cacheHander.delete(DictCacheKey.SYS_DICT_BY_TYPE_MAP.key(dict.getType()));
        cacheHander.delete(DictCacheKey.SYS_DICT_BY_VALUE.key(dict.getType(), dict.getValue()));
    }
}

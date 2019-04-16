/**
 * http://www.lbanma.com
 */
package com.wf.base.rpc.impl;

import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import com.wf.base.common.constants.DictCacheKey;
import com.wf.base.crud.BaseDictService;
import com.wf.base.dao.entity.BaseDict;
import com.wf.base.rpc.DictRpcService;
import com.wf.base.rpc.dto.BaseDictDto;
import com.wf.base.rpc.dto.DictValueLabelDto;
import com.wf.core.cache.CacheHander;
import com.wf.core.cache.CacheKey;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字典Service
 *
 * @author chris
 * @version 2014-05-16
 */
public class DictRpcServiceRpcImpl implements DictRpcService {
    @Autowired
    private CacheHander cacheHander;
    @Autowired
    private BaseDictService baseDictService;

    @Override
    public List<String> findTypeList() {
        return cacheHander.cache(DictCacheKey.SYS_DICT_ALL_LIST.key(), () -> baseDictService.findTypeList());
    }

    @Override
    public BaseDictDto getDict(final String type, final int value) {
        return BaseDictDto.toDto(baseDictService.getDictByValue(type, value));
    }

    /**
     * 根据type和value获取 对应label
     *
     * @param value
     * @param type
     * @param defaultLabel
     * @return
     */
    @Override
    public String getDictLabel(Integer value, String type, String defaultLabel) {
        if (StringUtils.isNotBlank(type) && value != null) {
            List<BaseDict> baseDicts = baseDictService.getDictList(type);
            for (BaseDict dict : baseDicts) {
                if (type.equals(dict.getType()) && value.equals(dict.getValue())) {
                    return dict.getLabel();
                }
            }
        }
        return defaultLabel;
    }

    /**
     * 根据type和label获取 对应value
     *
     * @param label
     * @param type
     * @param defaultValue
     * @return
     */
    @Override
    public Integer getDictValue(String label, String type, Integer defaultValue) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)) {
            List<BaseDict> baseDicts = baseDictService.getDictList(type);
            for (BaseDict dict : baseDicts) {
                if (type.equals(dict.getType()) && label.equals(dict.getLabel())) {
                    return dict.getValue();
                }
            }
        }
        return defaultValue;
    }

    /**
     * 获取字典类型type中特殊value对应的label字符串
     *
     * @param values   ","号分隔的value串
     * @param type
     * @param defValue
     * @return
     */
    @Override
    public String getSpecDictLabels(String values, String type, String defValue) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(values)) {
            List<String> valueList = Lists.newArrayList();
            String[] specValues = StringUtils.split(values, ",");
            for (String value : specValues) {
                valueList.add(getDictLabel(Integer.valueOf(value), type, defValue));
            }
            return StringUtils.join(valueList, ",");
        }
        return defValue;
    }


    /**
     * 获取type字典的lable集合
     *
     * @param type
     * @return
     */
    @Override
    public List<String> getDictLabelList(final String type) {
        return cacheHander.cache(DictCacheKey.SYS_DICT_TYPE_LABEL_LIST.key(type), () -> {
            List<BaseDict> list = baseDictService.getDictList(type);
            List<String> labelList = new ArrayList<>(list.size());
            for (BaseDict dict : list) {
                labelList.add(dict.getLabel());
            }
            return labelList;
        });
    }

    @Override
    public List<DictValueLabelDto> getDictKeyValueList(String type) {
        return cacheHander.cache(DictCacheKey.SYS_DICT_BY_TYPE_MAP.key(type), () -> {
            List<BaseDict> list = baseDictService.getDictList(type);
            List<DictValueLabelDto> labelList = new ArrayList<>(list.size());
            DictValueLabelDto kv;
            for (BaseDict dict : list) {
                kv = new DictValueLabelDto();
                kv.setKey(dict.getValue());
                kv.setValue(dict.getLabel());
                labelList.add(kv);
            }
            return labelList;
        });
    }

    @Override
    public List<BaseDictDto> getDictList(final String type) {
        List<BaseDict> baseDicts = baseDictService.getDictList(type);
        List<BaseDictDto> dtos = new ArrayList<>(baseDicts.size());
        for (BaseDict dict : baseDicts) {
            dtos.add(BaseDictDto.toDto(dict));
        }
        return dtos;
    }

    @Override
    public List<BaseDictDto> getSpecValueDictList(final String type, final String specValues) {
        return cacheHander.cache(DictCacheKey.SYS_DICT_BY_TYPE.key(type, specValues), () -> {
            List<BaseDict> dictList = baseDictService.getDictList(type);
            List<BaseDictDto> returnList = new ArrayList<>(dictList.size());
            if (StringUtils.isBlank(specValues)) {
                return dictList;
            } else {
                String[] idArray = specValues.split(",");
                List<String> idList = Arrays.asList(idArray);
                for (BaseDict tempDict : dictList) {
                    if (idList.contains(tempDict.getValue().toString())) {
                        returnList.add(BaseDictDto.toDto(tempDict));
                    }
                }
                return returnList;
            }
        }, CacheKey.MINUTE_5);
    }

    @Override
    public String getDictListJson(String type) {
        return JSONArray.toJSONString(baseDictService.getDictList(type));
    }
}

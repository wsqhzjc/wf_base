package com.wf.base.rpc;

import com.wf.base.rpc.dto.BaseDictDto;
import com.wf.base.rpc.dto.DictValueLabelDto;

import java.util.List;

public interface DictRpcService {
    /**
     * 查询字典类型列表
     *
     * @return
     */
    List<String> findTypeList();

    /**
     * 获取字典
     * @param type
     * @param value
     * @return
     */
    BaseDictDto getDict(String type, int value);

    /**
     * 根据type和value获取 对应label
     *
     * @param value
     * @param type
     * @param defaultLabel
     * @return
     */
    String getDictLabel(Integer value, String type, String defaultLabel);

    /**
     * 根据type和label获取 对应value
     *
     * @param label
     * @param type
     * @param defaultValue
     * @return
     */
    Integer getDictValue(String label, String type, Integer defaultValue);

    /**
     * 获取字典类型type中特殊value对应的label字符串
     *
     * @param values   ","号分隔的value串
     * @param type
     * @param defValue
     * @return
     */
    String getSpecDictLabels(String values, String type, String defValue);

    /**
     * 获取type字典的lable集合
     *
     * @param type
     * @return
     */
    List<String> getDictLabelList(String type);

    /**
     * 指定type类型的键值对
     *
     * @param type
     * @return
     */
    List<DictValueLabelDto> getDictKeyValueList(String type);

    /**
     * 获取type类型的字典列表
     *
     * @param type
     * @return
     */
    List<BaseDictDto> getDictList(String type);

    /**
     * 获取type类型字典的特殊value项
     *
     * @param type       字典type
     * @param specValues ","号分隔的value值
     * @return
     */
    List<BaseDictDto> getSpecValueDictList(String type, String specValues);

    /**
     * 返回字典type的列表（JSON）
     *
     * @param type
     * @return
     */
    String getDictListJson(String type);
}

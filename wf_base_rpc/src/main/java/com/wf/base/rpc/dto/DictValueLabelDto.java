package com.wf.base.rpc.dto;

import java.io.Serializable;

/**
 * value:label键值对格式
 *
 * @author chris
 */
public class DictValueLabelDto implements Serializable {
    private static final long serialVersionUID = -4729062099513190264L;
    private Integer key;
    private String value;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DictValueLabelDTO{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

package com.wf.base.dao.entity;

import com.wf.core.persistence.DataEntity;
import org.hibernate.validator.constraints.Length;

/**
 * 配置项Entity
 */
public class BaseConfig extends DataEntity {

    private static final long serialVersionUID = 1L;
    private String name;        // 名称（英文唯一）
    private String value;        // 值
    private String remark;        // 备注
    private Long channelId;     // 渠道号

    public BaseConfig() {
        super();
    }

    public BaseConfig(Long id) {
        super(id);
    }

    @Length(min = 0, max = 50, message = "名称（英文唯一）长度必须介于 0 和 50 之间")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min = 0, max = 255, message = "值长度必须介于 0 和 255 之间")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Length(min = 0, max = 255, message = "备注长度必须介于 0 和 255 之间")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }


}
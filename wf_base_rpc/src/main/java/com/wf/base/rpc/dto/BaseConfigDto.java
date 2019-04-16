package com.wf.base.rpc.dto;

import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author chris
 */
public class BaseConfigDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;        // 名称（英文唯一）
    private String value;        // 值
    private Long channelId;     // 渠道号


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "BaseConfigDTO{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", channelId=" + channelId +
                '}';
    }

    public static BaseConfigDto toDto(Object object) {
        if (object == null) {
            return null;
        }
        BaseConfigDto dto = new BaseConfigDto();
        BeanUtils.copyProperties(object, dto);
        return dto;
    }
}

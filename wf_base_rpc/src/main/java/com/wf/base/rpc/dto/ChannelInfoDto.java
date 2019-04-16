package com.wf.base.rpc.dto;


import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author chris
 */
public class ChannelInfoDto implements Serializable {
    private static final long serialVersionUID = -1;
    private Long id;
    private Long parentId;
    private String code;
    private String name;
    private Integer enable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public static ChannelInfoDto toDto(Object object) {
        if (object == null) {
            return null;
        }
        ChannelInfoDto dto = new ChannelInfoDto();
        BeanUtils.copyProperties(object, dto);
        return dto;
    }

    @Override
    public String toString() {
        return "ChannelInfoDto{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", enable=" + enable +
                '}';
    }
}
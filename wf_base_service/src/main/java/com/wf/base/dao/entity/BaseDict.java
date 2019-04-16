package com.wf.base.dao.entity;

import com.wf.core.persistence.DataEntity;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * 字典Entity
 *
 * @author chris
 * @version 2013-05-15
 */
public class BaseDict extends DataEntity {

    private static final long serialVersionUID = 1L;
    private Integer value;    // 数据值
    private String label;    // 标签名
    private String type;    // 类型
    private String description;// 描述
    private Integer sort;    // 排序
    private Long createBy;
    private Long updateBy;
    private String remarks;

    public BaseDict() {
        super();
    }

    public BaseDict(Long id) {
        super(id);
    }

    public BaseDict(Integer value, String label) {
        this.value = value;
        this.label = label;
    }

    @XmlAttribute
    @Length(min = 1, max = 100)
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @XmlAttribute
    @Length(min = 1, max = 100)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Length(min = 1, max = 100)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlAttribute
    @Length(min = 0, max = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return label;
    }
}
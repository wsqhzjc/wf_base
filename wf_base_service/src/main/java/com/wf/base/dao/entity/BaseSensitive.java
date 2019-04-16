package com.wf.base.dao.entity;

import com.wf.core.persistence.DataEntity;
/**
 * 敏感词
 * @author fxy
 * @date 2017/10/26
 */
public class BaseSensitive extends DataEntity {
    private static final long serialVersionUID = -1;
    private String content;
    public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
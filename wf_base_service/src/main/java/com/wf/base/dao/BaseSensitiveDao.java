package com.wf.base.dao;

import com.wf.base.dao.entity.BaseSensitive;
import com.wf.core.persistence.CrudDao;
import com.wf.core.persistence.MyBatisDao;

import java.util.List;
/**
 * 敏感词信息
 * @author fxy
 * @date 20017/10/26
 */
@MyBatisDao(tableName = "base_sensitive")
public interface BaseSensitiveDao extends CrudDao<BaseSensitive> {
    /**
     * 过去所有敏感词列表
     * @return
     */
    List<String> findAll();
}


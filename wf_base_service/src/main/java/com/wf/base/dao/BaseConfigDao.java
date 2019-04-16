/**
 * Copyright &copy; 2016 <a href="http://www.lbanma.com">lbanma</a> All rights reserved.
 */
package com.wf.base.dao;

import com.wf.base.dao.entity.BaseConfig;
import com.wf.core.persistence.CrudDao;
import com.wf.core.persistence.MyBatisDao;
import org.apache.ibatis.annotations.Param;

/**
 * 配置项DAO接口
 *
 * @author fuxin
 * @version 2016-08-08
 */
@MyBatisDao(tableName = "base_config")
public interface BaseConfigDao extends CrudDao<BaseConfig> {
    BaseConfig findByName(@Param("name")String name, @Param("channelId") Long channelId);
}
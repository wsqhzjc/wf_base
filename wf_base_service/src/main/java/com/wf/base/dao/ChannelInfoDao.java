package com.wf.base.dao;


import com.wf.base.dao.entity.ChannelInfo;
import com.wf.core.persistence.CrudDao;
import com.wf.core.persistence.MyBatisDao;

import java.util.List;

@MyBatisDao(tableName = "channel_info")
public interface ChannelInfoDao extends CrudDao<ChannelInfo> {

    List<ChannelInfo> findMainChannel();

    List<ChannelInfo> findSubChannel(Long parentId);

    List<ChannelInfo> findAll();
}

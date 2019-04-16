package com.wf.base.crud;

import com.wf.base.common.constants.ChannelCacheKey;
import com.wf.base.dao.ChannelInfoDao;
import com.wf.base.dao.entity.ChannelInfo;
import com.wf.core.cache.CacheKey;
import com.wf.core.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class ChannelInfoService extends CrudService<ChannelInfoDao, ChannelInfo> {

    /**
     * 渠道对象（缓存一天）
     */
    @Override
    public ChannelInfo get(final Long id) {
        return cacheHander.cache(ChannelCacheKey.CHANNEL_INFO_BY_ID.key(id), () -> dao.get(id), CacheKey.DAY_1);
    }

    /**
     * Channel主键自己生成
     */
    @Override
    public void save(ChannelInfo entity) {
        if (dao.get(entity.getId()) == null) {
            if (entity.getCreateTime() == null) {
                entity.setCreateTime(new Date());
            }
            dao.insert(entity);
        } else {
            this.preUpdate(entity);
            dao.update(entity);
        }
        clearCache(entity);
    }

    public List<ChannelInfo> findMainChannel() {
        return cacheHander.cache(ChannelCacheKey.CHANNEL_INFO_MAIN_CHANNEL.key(),
                () -> dao.findMainChannel(), CacheKey.DAY_1);
    }

    public List<ChannelInfo> findAll() {
        return cacheHander.cache(ChannelCacheKey.CHANNEL_INFO_ALL_CHANNEL.key(),
                () -> dao.findAll(), CacheKey.DAY_1);
    }


    public List<ChannelInfo> findSubChannel(final Long channelId) {
        return cacheHander.cache(ChannelCacheKey.CHANNEL_INFO_SUB_CHANNEL.key(channelId),
                () -> dao.findSubChannel(channelId), CacheKey.DAY_1);
    }

    /**
     * 清空缓存
     */
    @Override
    protected void clearCache(ChannelInfo entity) {
        cacheHander.delete(ChannelCacheKey.CHANNEL_INFO_BY_ID.key(entity.getId()));
        if (entity.getParentId() != null) {
            cacheHander.delete(ChannelCacheKey.CHANNEL_INFO_SUB_CHANNEL.key(entity.getParentId()));
        } else {
            cacheHander.delete(ChannelCacheKey.CHANNEL_INFO_MAIN_CHANNEL.key());
        }
        cacheHander.delete(ChannelCacheKey.CHANNEL_INFO_ALL_CHANNEL.key());
    }
}

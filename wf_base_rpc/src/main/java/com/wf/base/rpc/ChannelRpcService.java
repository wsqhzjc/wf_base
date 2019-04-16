package com.wf.base.rpc;


import com.wf.base.rpc.dto.ChannelInfoDto;
import com.wf.base.rpc.dto.PageDto;

import java.util.List;


/**
 * 渠道服务
 *
 * @author chris
 */
public interface ChannelRpcService {
    /**
     * 根据渠道编码获取
     *
     * @param id
     * @return
     */
    ChannelInfoDto get(Long id);

    /**
     * 获取所有主渠道
     *
     * @return
     */
    List<ChannelInfoDto> findMainChannel();

    /**
     * 获取子渠道
     *
     * @param channelId
     * @return
     */
    List<ChannelInfoDto> findSubChannel(final Long channelId);

    /**
     * 获取上级渠道编码
     *
     * @param channelId
     * @return
     */
    ChannelInfoDto getParentChannel(Long channelId);

    /**
     * 分页获取系统渠道信息
     * @param pageDto
     * @return
     */
    PageDto<ChannelInfoDto> find(PageDto<ChannelInfoDto> pageDto);

    /**
     * 获取系统所有渠道信息
     * @return
     */
    List<ChannelInfoDto> findAll();
}

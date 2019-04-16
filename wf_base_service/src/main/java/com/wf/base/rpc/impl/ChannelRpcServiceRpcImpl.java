package com.wf.base.rpc.impl;

import com.wf.base.crud.ChannelInfoService;
import com.wf.base.dao.entity.ChannelInfo;
import com.wf.base.rpc.ChannelRpcService;
import com.wf.base.rpc.dto.ChannelInfoDto;
import com.wf.base.rpc.dto.PageDto;
import com.wf.core.persistence.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 渠道服务
 *
 * @author chris
 */
public class ChannelRpcServiceRpcImpl implements ChannelRpcService {

    @Autowired
    private ChannelInfoService channelInfoService;

    @Override
    public ChannelInfoDto get(Long id) {
        return ChannelInfoDto.toDto(channelInfoService.get(id));
    }

    @Override
    public List<ChannelInfoDto> findMainChannel() {
        List<ChannelInfo> channelInfos = channelInfoService.findMainChannel();
        List<ChannelInfoDto> dtos = new ArrayList<>(channelInfos.size());
        for (ChannelInfo channelInfo : channelInfos) {
            dtos.add(ChannelInfoDto.toDto(channelInfo));
        }
        return dtos;
    }

    @Override
    public List<ChannelInfoDto> findAll() {
        List<ChannelInfo> channelInfos = channelInfoService.findAll();
        List<ChannelInfoDto> dtos = new ArrayList<>(channelInfos.size());
        for (ChannelInfo channelInfo : channelInfos) {
            dtos.add(ChannelInfoDto.toDto(channelInfo));
        }
        return dtos;
    }

    @Override
    public List<ChannelInfoDto> findSubChannel(Long channelId) {
        List<ChannelInfo> channelInfos = channelInfoService.findSubChannel(channelId);
        List<ChannelInfoDto> dtos = new ArrayList<>(channelInfos.size());
        for (ChannelInfo channelInfo : channelInfos) {
            dtos.add(ChannelInfoDto.toDto(channelInfo));
        }
        return dtos;
    }

    @Override
    public ChannelInfoDto getParentChannel(Long id) {
        ChannelInfo channelInfo = channelInfoService.get(id);
        if (channelInfo == null || channelInfo.getParentId() == null) {
            return null;
        } else {
            ChannelInfo parentChannel = channelInfoService.get(channelInfo.getParentId());
            return ChannelInfoDto.toDto(parentChannel);
        }
    }

    @Override
    public PageDto<ChannelInfoDto> find(PageDto<ChannelInfoDto> pageDto) {
        Page<ChannelInfo> page = new Page<>();
        page.setP(new ChannelInfo());
        BeanUtils.copyProperties(pageDto.getP(), page.getP());
        page.setStart(pageDto.getStart());
        page.setLength(pageDto.getLength());
        channelInfoService.findPage(page);
        BeanUtils.copyProperties(page, pageDto);
        pageDto.setData(new ArrayList<>());
        pageDto.setTotal(page.getiTotalRecords());
        ChannelInfoDto infoDto;
        for (ChannelInfo channelInfo : page.getData()) {
            infoDto = new ChannelInfoDto();
            infoDto.setName(channelInfo.getName());
            infoDto.setCode(channelInfo.getCode());
            infoDto.setId(channelInfo.getId());
            infoDto.setParentId(channelInfo.getParentId());
            pageDto.getData().add(infoDto);
        }
        pageDto.setP(null);
        return pageDto;
    }
}

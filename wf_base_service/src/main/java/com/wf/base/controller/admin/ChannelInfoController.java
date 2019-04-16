package com.wf.base.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.wf.base.crud.ChannelInfoService;
import com.wf.base.dao.entity.ChannelInfo;
import com.wf.core.persistence.Page;
import com.wf.core.utils.type.NumberUtils;
import com.wf.core.utils.type.StringUtils;
import com.wf.core.web.base.ExtJsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 字典管理
 *
 * @author zwf
 */
@RestController
@RequestMapping("/base/admin/channel")
public class ChannelInfoController extends ExtJsController {
    @Autowired
    private ChannelInfoService channelInfoService;

    /**
     * 配置项列表
     *
     * @return
     */
    @RequestMapping("/list")
    public Object list() {
        Page<ChannelInfo> page = getPage(ChannelInfo.class);
        return dataGrid(channelInfoService.findPage(page));
    }

    @RequestMapping("/storeList")
    public Object storeList() {
        JSONObject json = getRequestJson();
        long start = json.getLongValue("start");
        long length = json.getLongValue("limit");
        JSONObject data = json.getJSONObject("data");
        String searchKey = data != null ? data.getString("data") : null;
        ChannelInfo activityInfo = new ChannelInfo();
        if (StringUtils.isNotBlank(searchKey)) {
            String keyWord = searchKey.trim();
            if (NumberUtils.isDigits(keyWord)) {
                activityInfo.setId(NumberUtils.toLong(keyWord));
            } else {
                activityInfo.setName(keyWord);
            }
        }
        Page<ChannelInfo> page = new Page<>(activityInfo, start, length);
        return channelInfoService.findList(page);
    }

    /**
     * 保存配置项
     *
     * @return
     */
    @RequestMapping("/save")
    public Object save() {
        ChannelInfo form = getForm(ChannelInfo.class);
        if (form == null) {
            return error("请求参数错误");
        }
        ChannelInfo channelInfo = channelInfoService.get(form.getId());
        if (channelInfo != null) {
            form.setCreateTime(channelInfo.getCreateTime());
        } else {
            form.setCreateTime(new Date());
        }
        form.setUpdateTime(new Date());
        channelInfoService.save(form);
        return success();
    }

    @RequestMapping("/delete")
    public Object delete() {
        ChannelInfo entity = getForm(ChannelInfo.class);
        channelInfoService.delete(entity);
        return success();
    }
}

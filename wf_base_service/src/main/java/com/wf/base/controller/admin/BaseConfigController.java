package com.wf.base.controller.admin;

import com.wf.base.crud.BaseConfigService;
import com.wf.base.dao.entity.BaseConfig;
import com.wf.core.persistence.Page;
import com.wf.core.web.base.ExtJsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 配置项管理
 *
 * @author zwf
 */
@RestController
@RequestMapping("/base/admin/config")
public class BaseConfigController extends ExtJsController {

    @Autowired
    private BaseConfigService baseConfigService;

    /**
     * 配置项列表
     *
     * @return
     */
    @RequestMapping("/list")
    public Object list() {
        Page<BaseConfig> page = getPage(BaseConfig.class);
        return dataGrid(baseConfigService.findPage(page));
    }

    /**
     * 保存配置项
     *
     * @return
     */
    @RequestMapping("/save")
    public Object save() {
        BaseConfig form = getForm(BaseConfig.class);
        if (form == null) {
            return error("请求参数错误");
        }
        BaseConfig platSysConfig = baseConfigService.findByName(form.getName(), form.getChannelId());
        if (form.getId() == null && platSysConfig != null) {
            return error("配置项已经存在");
        }

        if (form.getId() != null && platSysConfig != null && !form.getId().equals(platSysConfig.getId())) {
            return error("配置项已经存在");
        }
        if (platSysConfig != null) {
            form.setCreateTime(platSysConfig.getCreateTime());
        } else {
            form.setCreateTime(new Date());
        }
        form.setUpdateTime(new Date());
        baseConfigService.save(form);
        return success();
    }

    @RequestMapping("/delete")
    public Object delete() {
        BaseConfig entity = getForm(BaseConfig.class);
        baseConfigService.delete(entity);
        return success();
    }
}

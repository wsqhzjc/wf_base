package com.wf.base.controller.admin;

import com.wf.base.crud.BaseSensitiveService;
import com.wf.base.dao.entity.BaseSensitive;
import com.wf.core.persistence.Page;
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
@RequestMapping("/base/admin/sensitive")
public class SensitiveWordController extends ExtJsController {
    @Autowired
    private BaseSensitiveService baseSensitiveService;

    /**
     * 配置项列表
     *
     * @return
     */
    @RequestMapping("/list")
    public Object list() {
        Page<BaseSensitive> page = getPage(BaseSensitive.class);
        return dataGrid(baseSensitiveService.findPage(page));
    }

    /**
     * 保存敏感字
     *
     * @return
     */
    @RequestMapping("/save")
    public Object save() {
        BaseSensitive form = getForm(BaseSensitive.class);
        if (form == null) {
            return error("请求参数错误");
        }
        BaseSensitive baseSensitive = baseSensitiveService.get(form.getId());
        if (baseSensitive != null) {
            form.setCreateTime(baseSensitive.getCreateTime());
        } else {
            form.setCreateTime(new Date());
        }
        form.setUpdateTime(new Date());
        baseSensitiveService.save(form);
        return success();
    }

    @RequestMapping("/delete")
    public Object delete() {
        BaseSensitive entity = getForm(BaseSensitive.class);
        baseSensitiveService.delete(entity);
        return success();
    }
}

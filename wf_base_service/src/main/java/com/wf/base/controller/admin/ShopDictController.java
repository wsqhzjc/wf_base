package com.wf.base.controller.admin;

import com.wf.base.crud.BaseDictService;
import com.wf.base.dao.entity.BaseDict;
import com.wf.core.persistence.Page;
import com.wf.core.web.base.ExtJsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 字典管理
 *
 * @author zwf
 */
@RestController
@RequestMapping("/base/admin/dict")
public class ShopDictController extends ExtJsController {
    @Autowired
    private BaseDictService baseDictService;

    /**
     * 配置项列表
     *
     * @return
     */
    @RequestMapping("/list")
    public Object list() {
        Page<BaseDict> page = getPage(BaseDict.class);
        return dataGrid(baseDictService.findPage(page));
    }

    /**
     * 根据类型获取字典列表
     *
     * @return
     */
    @RequestMapping("findByType")
    public Object list(@RequestParam("type") String type) {
        return baseDictService.getDictList(type);
    }

    /**
     * 保存配置项
     *
     * @return
     */
    @RequestMapping("/save")
    public Object save() {
        BaseDict form = getForm(BaseDict.class);
        if (form == null) {
            return error("请求参数错误");
        }
        BaseDict baseDict = baseDictService.get(form.getId());
        if (baseDict != null) {
            form.setCreateTime(baseDict.getCreateTime());
        } else {
            form.setCreateTime(new Date());
        }
        form.setUpdateTime(new Date());
        baseDictService.save(form);
        return success();
    }

    @RequestMapping("/delete")
    public Object delete() {
        BaseDict entity = getForm(BaseDict.class);
        baseDictService.delete(entity);
        return success();
    }
}

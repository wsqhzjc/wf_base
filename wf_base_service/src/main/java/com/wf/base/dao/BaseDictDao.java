/**
 * http://www.lbanma.com
 */
package com.wf.base.dao;

import com.wf.base.dao.entity.BaseDict;
import com.wf.core.persistence.CrudDao;
import com.wf.core.persistence.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典DAO接口
 *
 * @author www.lbanma.com
 * @version 2014-05-16
 */
@MyBatisDao(tableName = "base_dict")
public interface BaseDictDao extends CrudDao<BaseDict> {

    List<String> findTypeList(BaseDict dict);

    BaseDict getDictByValue(@Param("type") String type, @Param("value") int value);

    List<BaseDict> findByCond(BaseDict dict);
}

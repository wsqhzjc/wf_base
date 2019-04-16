package com.wf.base.rpc.impl;

import com.wf.base.common.sensitive.SensitiveWordHander;
import com.wf.base.rpc.SensitiveRpcService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 敏感词
 * @author fxy
 * @date 2017/11/10
 */
public class SensitiveRpcServiceImpl implements SensitiveRpcService {
    @Autowired
    private SensitiveWordHander sensitiveWordHander;

    /**
     * 敏感词替换
     * @param var1
     * @param var2
     * @return
     */
    @Override
    public String replace(String var1, int var2){
        return sensitiveWordHander.replace(var1,var2);
    }

    /**
     * 是否包含敏感词
     * @param var1
     * @param var2
     * @return
     */
    @Override
    public boolean isContains(String var1, int var2){
        return sensitiveWordHander.isContains(var1, var2);
    }

}

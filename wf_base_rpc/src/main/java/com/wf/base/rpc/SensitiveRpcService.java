package com.wf.base.rpc;

/**
 * 敏感词
 * @author fxy
 * @date 2017/11/10
 */
public interface SensitiveRpcService {
    int MIN_MATCH_TYPE = 1;
    int MAX_MATCH_TYPE = 2;
    String REPLACE_TARGET = "*";

    /**
     * 敏感词替换
     * @param var1
     * @param var2
     * @return
     */
    String replace(String var1, int var2);

    /**
     * 是否包含敏感词
     * @param var1
     * @param var2
     * @return
     */
    boolean isContains(String var1, int var2);

}

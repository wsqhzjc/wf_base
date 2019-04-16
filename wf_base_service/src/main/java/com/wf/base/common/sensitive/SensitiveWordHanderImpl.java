//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.wf.base.common.sensitive;

import java.util.*;

/**
 * 关键字
 * @author chris
 */
public class SensitiveWordHanderImpl implements SensitiveWordHander {
    private static final String IS_END = "isEnd";
    private WordsTransfer transfer;

    /**
     * 初始化
     * @param transfer
     */
    @Override
    public void init(WordsTransfer transfer) {
        this.transfer = transfer;
    }

    /**
     * 构建数据信息
     */
    @Override
    public Map<String, String> build() {
        Collection<String> collection = this.transfer.getWords();
        HashMap<String, String> sensitiveWordMap = new HashMap(collection.size());
        Iterator iterator = collection.iterator();

        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            Map nowMap = sensitiveWordMap;

            for (int i = 0; i < key.length(); ++i) {
                char keyChar = key.charAt(i);
                Object wordMap = nowMap.get(keyChar);
                if (wordMap != null) {
                    nowMap = (Map) wordMap;
                } else {
                    Map<String, String> newWorMap = new HashMap();
                    newWorMap.put(IS_END, "0");
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }

                if (i == key.length() - 1) {
                    nowMap.put(IS_END, "1");
                }
            }
        }

        return sensitiveWordMap;
    }

    @Override
    public boolean isContains(String txt, int matchType) {
        boolean flag = false;

        for (int i = 0; i < txt.length(); ++i) {
            int matchFlag = this.checkSensitiveWord(txt, i, matchType);
            if (matchFlag > 0) {
                flag = true;
            }
        }

        return flag;
    }

    @Override
    public String replace(String original, int matchType) {
        String resultTxt = original;
        Set<String> set = this.getSensitiveWord(original, matchType);

        String word;
        String replaceString;
        for (Iterator iterator = set.iterator(); iterator.hasNext(); resultTxt = resultTxt.replaceAll(word, replaceString)) {
            word = (String) iterator.next();
            replaceString = this.getReplaceChars("*", word.length());
        }

        return resultTxt;
    }

    private String getReplaceChars(String replaceChar, int length) {
        StringBuilder stringBuilder = new StringBuilder(replaceChar);

        for (int i = 1; i < length; ++i) {
            stringBuilder.append(replaceChar);
        }
        return stringBuilder.toString();
    }

    private Set<String> getSensitiveWord(String txt, int matchType) {
        Set<String> sensitiveWordList = new HashSet();

        for (int i = 0; i < txt.length(); ++i) {
            int length = this.checkSensitiveWord(txt, i, matchType);
            if (length > 0) {
                sensitiveWordList.add(txt.substring(i, i + length));
                i = i + length - 1;
            }
        }

        return sensitiveWordList;
    }

    public int checkSensitiveWord(String txt, int beginIndex, int matchType) {
        boolean flag = false;
        int matchFlag = 0;
        Map nowMap = this.transfer.getSensitive();

        for (int i = beginIndex; i < txt.length(); ++i) {
            char word = txt.charAt(i);
            nowMap = (Map) nowMap.get(word);
            if (nowMap == null) {
                break;
            }

            ++matchFlag;
            if ("1".equals(nowMap.get(IS_END))) {
                flag = true;
                if (1 == matchType) {
                    break;
                }
            }
        }

        if (matchFlag < 2 || !flag) {
            matchFlag = 0;
        }

        return matchFlag;
    }
}

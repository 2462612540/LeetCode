/**
 * Copyright (C), 2018-2020
 * FileName: wordBreak139
 * Author:   xjl
 * Date:     2020/6/1 22:10
 * Description: 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 */
package leetcode;

import org.junit.Test;

import java.util.List;

public class wordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() == 0) {
            return true;
        } else {
            String s1 = wordDict.get(0);
            s.contains(s1);
            //将s中的删除
            for (int i = 0; i < s1.length(); i++) {
                s.replace(s1.charAt(i), ' ');
            }
            //将wordDict也删除
            wordDict.remove(s1);
            //递归调用
            wordBreak(s, wordDict);
        }
        return false;
    }

    @Test
    public void test() {

    }
}

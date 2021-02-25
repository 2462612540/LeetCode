/**
 * Copyright (C), 2018-2020
 * FileName: wordSubsets916
 * Author:   xjl
 * Date:     2020/6/10 15:35
 * Description: 916. 单词子集
 */
package leetcode练习题;

import java.util.ArrayList;
import java.util.List;

public class wordSubsets916 {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bmax = count("");
        for (String b : B) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; ++i)
                bmax[i] = Math.max(bmax[i], bCount[i]);
        }

        List<String> ans = new ArrayList();
        search:
        for (String a : A) {
            int[] aCount = count(a);
            for (int i = 0; i < 26; ++i)
                if (aCount[i] < bmax[i])
                    continue search;
            ans.add(a);
        }
        return ans;
    }

    public int[] count(String S) {
        int[] ans = new int[26];
        for (char c : S.toCharArray())
            ans[c - 'a']++;
        return ans;
    }
}

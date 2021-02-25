/**
 * Copyright (C), 2018-2020
 * FileName: 解码方法91
 * Author:   xjl
 * Date:     2020/9/8 14:04
 * Description:
 */
package 计算机程序算法分类.动态规划问题集合;

import java.util.HashMap;

public class 解码方法91 {

    public int numDecodings(String s) {
        return getAns(s, 0);
    }

    private int getAns(String s, int start) {
        //划分到了最后返回 1
        if (start == s.length()) {
            return 1;
        }
        //开头是 0,0 不对应任何字母，直接返回 0
        if (s.charAt(start) == '0') {
            return 0;
        }
        //得到第一种的划分的解码方式
        int ans1 = getAns(s, start + 1);
        int ans2 = 0;
        //判断前两个数字是不是小于等于 26 的
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if (ten + one <= 26) {
                ans2 = getAns(s, start + 2);
            }
        }
        return ans1 + ans2;
    }

    /**
     * i=len(s)-2开始
     * dp [ i ] = dp[ i + 1 ] + dp [ i + 2 ]
     * @param s
     * @return
     */
    public int numDecodings2(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        //将递归法的结束条件初始化为 1
        dp[len] = 1;
        //最后一个数字不等于 0 就初始化为 1
        if (s.charAt(len - 1) != '0') {
            dp[len - 1] = 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            //当前数字时 0 ，直接跳过，0 不代表任何字母
            if (s.charAt(i) == '0') {
                continue;
            }
            int ans1 = dp[i + 1];
            //判断两个字母组成的数字是否小于等于 26
            int ans2 = 0;
            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) {
                ans2 = dp[i + 2];
            }
            dp[i] = ans1 + ans2;
        }
        return dp[0];
    }

    public int numDecodings3(String s) {
        HashMap<Integer, Integer> memoization = new HashMap<>();
        return getAns(s, 0, memoization);
    }

    private int getAns(String s, int start, HashMap<Integer, Integer> memoization) {
        //表示的是的s的长度 到了最后的一个分割位置
        if (start == s.length()) {
            return 1;
        }
        //如果还第一个位置为0 表示的是的0
        if (s.charAt(start) == '0') {
            return 0;
        }
        //判断之前是否计算过
        int m = memoization.getOrDefault(start, -1);
        if (m != -1) {
            return m;
        }
        int ans1 = getAns(s, start + 1, memoization);
        int ans2 = 0;
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if (ten + one <= 26) {
                ans2 = getAns(s, start + 2, memoization);
            }
        }
        //将结果保存
        memoization.put(start, ans1 + ans2);
        return ans1 + ans2;
    }


    public int numDecodings5(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return dfs(s, 0);
    }

    //递归的套路，加一个index控制递归的层次
    private int dfs(String s, int start) {
        //递归的第一步，应该是加终止条件，避免死循环。
        if (s.length() == start) {
            return 1;
        }
        //以0位开始的数是不存在的
        if (s.charAt(start) == '0') {
            return 0;
        }
        //递归的递推式应该是如果index的后两位小于等于26，  
        // dfs(s, start) = dfs(s, start+1)+dfs(s, start+2)   
        // 否则dfs(s, start) = dfs(s, start+1)
        int ans1 = dfs(s, start + 1);
        int ans2 = 0;
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = (s.charAt(start + 1) - '0');
            if (ten + one <= 26) {
                ans2 = dfs(s, start + 2);
            }
        }
        return ans1 + ans2;
    }
}

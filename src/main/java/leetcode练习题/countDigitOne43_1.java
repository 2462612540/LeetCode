/**
 * Copyright (C), 2018-2020
 * FileName: countDigitOne43_1
 * Author:   xjl
 * Date:     2020/6/17 10:24
 * Description: 面试题43. 1～n整数中1出现的次数
 */
package leetcode练习题;

public class countDigitOne43_1 {

    /**
     * 暴力求解的方法
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += countOne(i);
        }
        return res;
    }

    private int countOne(int n) {
        int ans = 0;
        while (n > 0) {
            if (n % 10 == 1) ans++;
            n /= 10;
        }
        return ans;
    }

}

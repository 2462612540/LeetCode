/**
 * Copyright (C), 2018-2020
 * FileName: 青蛙跳
 * Author:   xjl
 * Date:     2020/9/14 14:04
 * Description:
 */
package 牛客面试必会100题;

import org.junit.Test;

public class 青蛙跳 {

    @Test
    public void test() {
        int res = Fibonacci(2);
        System.out.println(res);
    }

    //dp[i]=dp[i-1]+dp[i-2]
    public int JumpFloor(int target) {
        if (target <= 2) return target;
        int[] array = new int[target + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i =2; i <= target; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[target];
    }

    public int Fibonacci(int n) {
        if (n <= 1) return n;
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }
}

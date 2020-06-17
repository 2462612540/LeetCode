/**
 * Copyright (C), 2018-2020
 * FileName: maxScoreSightseeingPair1014
 * Author:   xjl
 * Date:     2020/6/17 9:21
 * Description: 1014. 最佳观光组合
 */
package Array;

import org.junit.Test;

public class maxScoreSightseeingPair1014 {
    /**
     * 但是时间超过了限制 这是暴力求解的方法
     *
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        int result = 0;
        int max = 0;
        //分别遍历每一次的结果
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                result = result > (A[i] + A[j] + i - j) ? result : (A[i] + A[j] + i - j);
            }
        }
        return result;
    }

    /**
     * 数据的动态规划问题
     *
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair2(int[] A) {
        int res = 0, cur = A[0] + 0;
        for (int j = 1; j < A.length; ++j) {
            res = Math.max(res, cur + A[j] - j);
            cur = Math.max(cur, A[j] + j);
        }
        return res;
    }

    @Test
    public void test() {
        int[] array = {8, 1, 5, 2, 6};
        int i = maxScoreSightseeingPair2(array);
        System.out.println(i);
    }

}

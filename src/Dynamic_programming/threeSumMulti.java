/**
 * Copyright (C), 2018-2020
 * FileName: threeSumMulti
 * Author:   xjl
 * Date:     2020/6/23 9:15
 * Description: 923. 三数之和的多种可能
 */
package Dynamic_programming;

import org.junit.Test;

import java.util.Arrays;

public class threeSumMulti {
    /**
     * 暴力枚举法 时间超出限制
     *
     * @param A
     * @param target
     * @return
     */
    public int threeSumMulti(int[] A, int target) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                for (int k = j + 1; k < A.length; k++) {
                    if (A[i] + A[j] + A[k] == target && i < j && j < k) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public int threeSumMulti2(int[] A, int target) {
        int MOD = 1_000_000_007;
        long ans = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length; ++i) {
            int T = target - A[i];
            int j = i + 1, k = A.length - 1;
            while (j < k) {
                if (A[j] + A[k] < T)
                    j++;
                else if (A[j] + A[k] > T)
                    k--;
                else if (A[j] != A[k]) {
                    int left = 1, right = 1;
                    while (j + 1 < k && A[j] == A[j + 1]) {
                        left++;
                        j++;
                    }
                    while (k - 1 > j && A[k] == A[k - 1]) {
                        right++;
                        k--;
                    }
                    ans += left * right;
                    ans %= MOD;
                    j++;
                    k--;
                } else {
                    ans += (k - j + 1) * (k - j) / 2;
                    ans %= MOD;
                    break;
                }
            }
        }
        return (int) ans;
    }

    @Test
    public void test() {
        int[] A = {1, 1, 2, 2, 2, 2};
        int i = threeSumMulti2(A, 5);
        System.out.println(i);
    }
}

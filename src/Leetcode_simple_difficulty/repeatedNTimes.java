/**
 * Copyright (C), 2018-2020
 * FileName: repeatedNTimes
 * Author:   xjl
 * Date:     2020/3/5 9:25
 * Description: 在大小为 2N 的数组 A 中有 N+1 个不同的元素，
 * 其中有一个元素重复了 N 次。  返回重复了 N 次的那个元素。
 */
package Leetcode_simple_difficulty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 需要考虑一下时间和空间的算法更新
 */
public class repeatedNTimes {
    public static int repeatedNTimes(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) == A.length / 2) {
                return key;
            }
        }
        return 0;
    }

    public static int repeatedNTimes2(int[] A) {
        Arrays.sort(A);
        int[] res = new int[A[A.length]];
        for (int i = 0; i < A.length; i++) {
            res[A[i]] += 1;
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] == A.length / 2) {
                return A[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 5, 3, 2};
        System.out.println(repeatedNTimes2(nums));
    }
}

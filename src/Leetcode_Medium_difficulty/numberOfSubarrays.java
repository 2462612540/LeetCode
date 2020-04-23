/**
 * Copyright (C), 2018-2020
 * FileName: numberOfSubarrays
 * Author:   xjl
 * Date:     2020/4/21 8:48
 * Description: 给你一个整数数组 nums 和一个整数 k。  如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。  请返回这个数组中「优美子数组」的数目。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package Leetcode_Medium_difficulty;

import org.junit.Test;

public class numberOfSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return 0;
        // 双指针
        int left = 0, right = 0;
        int count = 0; // 连续子数组中奇数的个数
        int res = 0;
        int preEven = 0; // 记录第一个奇数前面的偶数个数
        while (right < nums.length) {// 连续子数组中奇数个数不够

            if (count < k) {
                if (nums[right] % 2 != 0) count++;
                right++; // 移动右侧指针
            }
            // 连续子数组中奇数个数够了，看第一个奇数前面有多少个偶数
            if (count == k) {
                preEven = 0;
                while (count == k) {
                    res++;
                    if (nums[left] % 2 != 0) count--;
                    left++;
                    preEven++;
                }
            } else {
                res += preEven; // 每次遇到 right 为偶数的时候就进行累加 相当于区间前面偶数个数 * 后面偶数个数
            }
        }
        return res;
    }

    @Test
    public Boolean test() {

        int[] number = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k = 2;
        System.out.println(numberOfSubarrays(number, k));
        return  false;
    }
}

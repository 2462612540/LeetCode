/**
 * Copyright (C), 2018-2020
 * FileName: minSubArrayLen209
 * Author:   xjl
 * Date:     2020/6/28 8:41
 * Description: 长度最小的子数组
 */
package Array;

import org.junit.Test;

public class minSubArrayLen209 {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int sum = 0;
        int length = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (sum >= s) {
                    break;
                } else {
                    sum += nums[j];
                    ++length;
                }
            }
            if (sum >= s) {
                result = result < length ? result : length;
            }
            length = 0;
            sum = 0;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public int minSubArrayLen1(int s, int[] nums) {
        //[start end]
        // start++ sum>=s _>sum<s [start-1 end]
        int start = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s && start <= i) {
                sum -= nums[start++];
            }
            if (start > 0 && sum + nums[start - 1] >= s) {
                min = Math.min(min, i - start + 2);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen2(int s, int[] nums) {
        int result = 0;
        int start = 0;
        int cursum = 0;

        for (int i = 0; i < nums.length; i++) {
            cursum += nums[i];
            while (cursum - nums[start] >= s) {
                cursum -= nums[start++];
            }
            if (cursum >= s) {
                if (result == 0 || result > i - start + 1) {
                    result = i - start + 1;
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] array = {2, 3, 1, 2, 4, 3};
        int i = minSubArrayLen2(7, array);
        System.out.println(i);

    }

}

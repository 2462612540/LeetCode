/**
 * Copyright (C), 2018-2020
 * FileName: 最大的连续的1的个数
 * Author:   xjl
 * Date:     2020/11/3 15:11
 * Description:
 */
package 数组问题;

import org.junit.Test;

public class 最大的连续的1的个数 {
    /**
     * 采用的是的动态规划的数组
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                max = max > count ? max : count;
                count = 0;
            }
        }
        max = max > count ? max : count;
        return max;
    }


    public int findMaxConsecutiveOnes1(int[] nums) {
        int res = 0;
        int count = 0;
        for(int num : nums){
            if(num == 1){
                count++;
            }else{
                count = 0;
            }
            res = Math.max(res,count);
        }
        return res;
    }

    @Test
    public void test() {
        int res = findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1});
        System.out.println(res);
    }

}

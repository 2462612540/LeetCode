/**
 * Copyright (C), 2018-2020
 * FileName: singleNumbers
 * Author:   xjl
 * Date:     2020/4/3 11:48
 * Description: 面试题56 - I. 数组中数字出现的次数
 */
package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class singleNumbers {
    public int[] singleNumbers(int[] nums) {
        int count=nums.length;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                nums[i] = 0;
                nums[i - 1] = 0;
                count-=2;
            }

        }
        Arrays.sort(nums);
        int[] res=new int[count];
        int index=0;
       for (int i=0;i<nums.length;i++){
           if (nums[i]!=0){
               res[index++]=nums[i];
           }
       }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 10, 4, 1, 4, 3, 3};
        singleNumbers(nums);
    }

}

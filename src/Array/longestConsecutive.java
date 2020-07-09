/**
 * Copyright (C), 2018-2020
 * FileName: longestConsecutive
 * Author:   xjl
 * Date:     2020/7/7 14:36
 * Description: 128. 最长连续序列
 */
package Array;

import org.junit.Test;

import java.util.Arrays;

public class longestConsecutive {

    public int longestConsecutive(int[] nums) {
        int result = 1;
        int length = 1;
        //先排序
        Arrays.sort(nums);
        //遍历一遍
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==nums[i-1]){
                continue;
            }
            if (nums[i] == nums[i-1] + 1) {
                ++length;
                result=length;
            } else {
                length = 1;
            }
            result = result > length ? result : length;
        }
        return result;
    }

    @Test
    public void test() {
        int[] array = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        int i = longestConsecutive(array);
        System.out.println(i);

    }

}

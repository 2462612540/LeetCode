/**
 * Copyright (C), 2018-2020
 * FileName: minSubsequence1403
 * Author:   xjl
 * Date:     2020/8/3 14:55
 * Description: 1403. 非递增顺序的最小子序列
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minSubsequence1403 {

    public static List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        List<Integer> list = new ArrayList<>();
        int scur = 0;
        for(int i = nums.length-1;i >= 0;i--){
            scur += nums[i];
            if(scur > sum - scur){
                list.add(nums[i]);
                break;
            }else{
                list.add(nums[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array={4,3,10,9,8};
        minSubsequence(array);

    }
}

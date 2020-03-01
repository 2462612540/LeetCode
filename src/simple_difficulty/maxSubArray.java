/**
 * Copyright (C), 2018-2020
 * FileName: maxSubArray
 * Author:   xjl
 * Date:     2020/3/1 14:45
 * Description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 */
package simple_difficulty;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
 * 这个题目一共分为两部分
 * 1 找到练习的数组 并记录下标的开始的位置， 并计算这个连续的数组和的大小
 * <p>
 * 思路：
 */
public class maxSubArray {

    public static int maxSubArray(int[] nums) {
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            //表示最后一个数据
            if (i + 1 == nums.length) {
                return  res;
            } else {
                //表示最后一个数据
                if(nums[i+1]>nums[i]){
                    res+=nums[i];
                }else {
                    res=0;

                }

            }

        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}

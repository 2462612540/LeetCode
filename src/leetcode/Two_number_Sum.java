/**
 * Copyright (C), 2018-2020
 * FileName: Two_number_Sum
 * Author:   xjl
 * Date:     2020/2/28 12:15
 * Description:给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：1将数组中的数据放入map中。
 *      2在利用map中的匹配来找到map中是否存在这个数
 *      3利用mapd的函数找到他的下标并返回
 */
public class Two_number_Sum {

    public static int[] twoSum(int[] nums, int target) {
        int[] list=new int[2];
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int key:map.keySet()){
            if(map.containsKey(target-key)){
                list[0]=map.get(key);
                list[1]=map.get(target-key);
                break;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums= {3,3};
        int target=6;
        int[] result=twoSum(nums,target);
        System.out.println(result[0]+ "----"+result[1]);
    }
}

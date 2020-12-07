/**
 * Copyright (C), 2018-2020
 * FileName: containsDuplicate
 * Author:   xjl
 * Date:     2020/3/3 13:35
 * Description: 给定一个整数数组，判断是否存在重复元素。
 */
package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class containsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Set set = new HashSet();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        if(set.size()==nums.length){
            return false;
        }else {
            return true;
        }
    }

    public static boolean containsDuplicate2(int[] nums) {
        return Arrays.stream(nums).distinct().count() != nums.length;//Stream.distinct() 列表去重示例
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }
}

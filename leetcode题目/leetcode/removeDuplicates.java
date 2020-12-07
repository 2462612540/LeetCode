/**
 * Copyright (C), 2018-2020
 * FileName: removeDuplicates80
 * Author:   xjl
 * Date:     2020/2/29 15:29
 * Description: 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 */
package leetcode;

/**
 *不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 1 遍历数组从第二个开始计算
 *
 */
public class removeDuplicates {
    public static int removeDuplicates(int[] nums) {
        int count=0;
        int res=1;
        for (int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                count++;
            }else {
                res++;
                nums[i-count]=nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={1,1,2};
        System.out.println(removeDuplicates(nums));
    }
}

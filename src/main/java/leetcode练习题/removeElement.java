/**
 * Copyright (C), 2018-2020
 * FileName: removeElement
 * Author:   xjl
 * Date:     2020/2/29 17:32
 * Description: 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 */
package leetcode练习题;

/**
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 遍历数组 将目标值记录重复的数字 有多少个并在下一次意见不同的时候就减少这个数字的个数
 *
 */
public class removeElement {
    public static int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                count++;
            }else {
                nums[i-count]=nums[i];
            }
        }
        return nums.length-count;
    }

    public static void main(String[] args) {
        int[] nums={3,2,2,3};
        int val=2;
        System.out.println(removeElement(nums,val));
    }
}

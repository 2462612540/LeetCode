/**
 * Copyright (C), 2018-2020
 * FileName: majorityElement
 * Author:   xjl
 * Date:     2020/3/5 10:00
 * Description: 如果数组中多一半的数都是同一个，则称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 */
package NiuKeCode;

import java.util.Arrays;

public class majorityElement {
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    count++;
                } else {
                    count = 1;
                }
                if (count > nums.length / 2) {
                    return nums[i];
                }
            }
        }
        if(nums.length==1){
            return nums[0];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num = {3, 2};
        System.out.println(majorityElement(num));
    }
}

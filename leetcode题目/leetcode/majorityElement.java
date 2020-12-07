/**
 * Copyright (C), 2018-2020
 * FileName: majorityElement
 * Author:   xjl
 * Date:     2020/3/2 15:03
 * Description: 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。  你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
package leetcode;

import java.util.*;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 遍历数组，两层遍历 这样在每次能够找到是否大于int(n/2)的个数
 */
public class majorityElement {
    public static int majorityElement(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                    if (count > (int) (nums.length / 2)) {
                        return nums[i];
                    }
                }
            }
            count = 0;
        }
        return 0;
    }

    public static int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int key : map.keySet()) {
            for (int i = 0; i < nums.length; i++) {
                if (key == nums[i]) {
                    count++;
                }
            }
            if (count > (int) (nums.length / 2)) {
                return key;
            } else {
                count = 0;
            }
        }
        return 0;

    }

    public static int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static List<Integer> majorityElement4(int[] nums) {
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }
        int n=0;
        for (int key : map.keySet()) {
            for (int i = 0; i < nums.length; i++) {
                if (key == nums[i]) {
                    n++;
                }
                if (n > (int) (nums.length /3)) {
                    list.add(key);
                    n=0;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        List res = majorityElement4(nums);
        System.out.println(res);
    }
}

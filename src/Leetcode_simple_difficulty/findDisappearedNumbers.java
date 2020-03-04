/**
 * Copyright (C), 2018-2020
 * FileName: findDisappearedNumbers
 * Author:   xjl
 * Date:     2020/3/2 9:45
 * Description: 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 */
package Leetcode_simple_difficulty;

import java.util.*;

public class findDisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List list = new ArrayList();
        //将数据存入map中
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], nums[i]);
        }
        //遍历的数据找打没有的发现的数据 将没有的数据存入list中
        for (int i = 1; i < nums.length + 1; i++) {
            if (!map.containsValue(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) {

        List list = new ArrayList();
        if(nums.length==0){
            return list;
        }
        //利用冒泡排序 将数字快速排序
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        //整理好的数组，接着就是遍历从小的值开始
        int count=0;
        for(int i=1;i<nums.length+1;i++){
            for(int j=0;j<nums.length;j++){
                if(i==nums[j]){
                    count++;
                }
            }
            if(count==0){
                list.add(i);
            }else {
                count=0;
            }
        }
        return list;
    }

    public static List<Integer> findDisappearedNumbers3(int[] nums){
        HashSet<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        LinkedList<Integer> targetList = new LinkedList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!numsSet.contains(i)) {
                targetList.add(i);
            }
        }
        return targetList;
    }
    public static void main(String[] args) {
        int[] nums = {1,1};
        List list = findDisappearedNumbers3(nums);
        System.out.println(list);
    }
}

package 牛客网名企高频面试题2020; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.数组中的相加和位0的三元组
 * Author:   xjl
 * Date:     2020/9/29 9:41
 * Description:
 */


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 采用的是的一份数组+双指针遍历来  同时来要保证不能有重复的元素的
 */
public class 数组中的相加和位0的三元组 {

    @Test
    public void test() {
        int[] array = {-2,0,1,1,2};
        ArrayList<ArrayList<Integer>> lists = threeSum(array);
        for (ArrayList<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if (num.length == 0) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            int target = 0 - num[i];
            int left = i + 1;
            int right = num.length - 1;
            while (left <= right) {
                if (num[left] + num[right] > target) {
                    right--;
                } else if (num[left] + num[right] < target) {
                    left++;
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[left]);
                    list.add(num[right]);
                    if (!lists.contains(list)) {
                        lists.add(list);
                    }
                    left++;
                    right--;
                }
            }
        }
        return lists;
    }
}

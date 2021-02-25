/**
 * Copyright (C), 2018-2020
 * FileName: MoreThanHalfNum_Solution
 * Author:   xjl
 * Date:     2020/5/9 9:49
 * Description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
package 牛客网练习题;

import org.junit.Test;

import java.util.*;

public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution2(int[] array) {
        int count = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], count);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) > array.length / 2) {
                return key;
            }
        }
        return -1;
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        Arrays.sort(array);
        int count = 1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > array.length / 2) {
                return array[i];
            }
        }
        return 0;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k > input.length) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    @Test
    public void test() {
        int[] array = {1};
        System.out.println(MoreThanHalfNum_Solution(array));
    }

    @Test
    public void test1() {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        List list = GetLeastNumbers_Solution(array, 4);
        System.out.println(list.toString());
    }
}

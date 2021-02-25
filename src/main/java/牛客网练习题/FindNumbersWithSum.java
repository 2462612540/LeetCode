/**
 * Copyright (C), 2018-2020
 * FileName: FindNumbersWithSum
 * Author:   xjl
 * Date:     2020/5/13 11:11
 * Description: 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
package 牛客网练习题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    if (list.isEmpty()) {
                        list.add(array[i]);
                        list.add(array[j]);
                    } else {
                        if (list.get(0) * list.get(1) > array[i] * array[j]) {
                            list.clear();
                            list.add(array[i]);
                            list.add(array[j]);
                        }
                    }
                }
            }
        }
        return list;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 4, 7, 8, 11, 15};
        int sum = 15;

        List<Integer> list = FindNumbersWithSum(nums, sum);
        for (int va : list) {
            System.out.println(va);
        }
    }
}

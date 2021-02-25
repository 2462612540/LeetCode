/**
 * Copyright (C), 2018-2020
 * FileName: ArrayMaxLength
 * Author:   xjl
 * Date:     2020/3/21 8:56
 * Description: 最大的长度
 */
package leetcode练习题;

import org.junit.Test;

import java.util.Arrays;

/**
 * 求解最大的长度的数据
 */
public class ArrayMaxLength {
    public int test2(int[] nubers) {
        int res = 0;
        int maxlength = 1;
        for (int j = 1; j < nubers.length; j++) {
            if (nubers[j] > nubers[j - 1]) {
                maxlength++;
            } else {
                res = maxlength > res ? maxlength : res;
                maxlength = 1;
            }
        }
        res = maxlength > res ? maxlength : res;
        return res;
    }

    /**
     * 实现的是手撕的二分查找的代码
     * start<=end指针
     *
     */
    public int test3() {
        int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Arrays.sort(number);
        int target = 9;
        //这里两个指针
        int start = 0;
        int end = number.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (number[mid] == target) {
                return mid;
            }
            if (number[mid] > target) {
                end = mid - 1;
            }
            if (number[mid] < target) {
                start = mid + 1;
            }
        }
        return 0;
    }

    @Test
    public void test4() {
        System.out.println(test3());
    }

    @Test
    public void test() {
        int[] numbers = {1};
        System.out.println(test2(numbers));
    }
}



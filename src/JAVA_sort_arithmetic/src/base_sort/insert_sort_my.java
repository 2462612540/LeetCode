/**
 * Copyright (C), 2018-2020
 * FileName: insert_sort_my
 * Author:   xjl
 * Date:     2020/3/23 17:29
 * Description: 手写插入的算法
 */
package JAVA_sort_arithmetic.src.base_sort;

import org.junit.Test;

public class insert_sort_my {

    public int[] insert_sort(int[] numbers) {
        //间数据为已经排序的和没有排序的
        //第一个数比较数字 第二个是比较的后面的数字如果是比较的大小，如果是小的话你那么就交换
        for (int i = 1; i < numbers.length; i++) {
            for (int j = i; j > 0; j--) {
                if (numbers[j] < numbers[j - 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return numbers;
    }

    /**
     * 测试插入算法
     */
    @Test
    public void test() {
        int[] numbers = {5, 1, 8, 9, 4, 5, 8, 6};
        for (Integer va : insert_sort(numbers)) {
            System.out.println(va);
        }
    }

}

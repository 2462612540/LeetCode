/**
 * Copyright (C), 2018-2020
 * FileName: Select_sort_my
 * Author:   xjl
 * Date:     2020/3/23 18:30
 * Description: 选择排序
 */
package JAVA_sort_arithmetic.src.base_sort;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//选择排序就是选择出来最下下标 然后在交换第一个
public class Select_sort_my {
    public int[] select(int[] number) {
        for (int i = 0; i < number.length - 1; i++) {
            //记录最小的位置 并找到最小的值
            int min = i;
            for (int j = 1; j < number.length; j++) {
                if (number[min] > number[j]) {
                    min = j;
                }
            }
            //交换第i出值
            int temp = number[i];
            number[i] = number[min];
            number[min] = temp;
        }
        return number;
    }

    @Test
    public void test() {
        int[] numbers = {5, 1, 8, 9, 4, 5, 8, 6};
        for (Integer va : select(numbers)) {
            System.out.println(va);
        }
        Map map=new HashMap<>();

    }
}

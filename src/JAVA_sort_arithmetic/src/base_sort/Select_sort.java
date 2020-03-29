/**
 * Copyright (C), 2018-2020
 * FileName: Select_sort
 * Author:   xjl
 * Date:     2020/3/24 8:18
 * Description: 选择排序
 */
package JAVA_sort_arithmetic.src.base_sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//选择排序就是为了在剩下的数据中找到最小的数然后与i进行交换
public class Select_sort {
    public int[] select(int[] numbers) {
        //第一遍是遍历从第一个到倒数的第二个
        for (int i = 0; i < numbers.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[min]) {
                    min = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[min];
            numbers[min] = temp;
        }
        return numbers;
    }

    /**
     * 插入时候就是为了在将剩下的开始插入到里面去
     *
     * @param numbers
     * @return
     */
    public int[] insert(int[] numbers) {
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

    @Test
    public void test2() {
        int[] numbers = {5, 1, 8, 9, 4, 5, 8, 6};
        for (Integer va : insert(numbers)) {
            System.out.println(va);
        }
        String[] Array = {"a", "b", "c", "d", "e"};

    }

    @Test
    public void test3() {
        String[] aa = {"a", "b", "c", "d", "e"};
        List list = Arrays.asList(aa);
        Collections.reverse(list);
        System.out.println(list);
        //System.out.println(new StringBuilder(Arrays.toString(aa)).reverse().toString());
        //System.out.println(new StringBuilder(Array.toString()).reverse().toString());
        System.out.println("*************************************");
        StringBuffer sb = new StringBuffer("abcd");
        System.out.println(sb.reverse().toString());
    }

    @Test
    public void test() {
        int[] numbers = {5, 1, 8, 9, 4, 5, 8, 6};
        for (Integer va : select(numbers)) {
            System.out.println(va);
        }
    }
}

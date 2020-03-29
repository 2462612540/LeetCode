/**
 * Copyright (C), 2018-2020
 * FileName: shell_my
 * Author:   xjl
 * Date:     2020/3/24 11:51
 * Description: 希尔排序
 */
package JAVA_sort_arithmetic.src.high_sort;

import org.junit.Test;

/**
 * 希尔排序的原理是
 * 选定一个增长的量h 按照增长的量h作为数据的分组的依据 对数据的进行分组
 * 对分好组的每一组数据完成插入的排序
 * 减少增长量 最下减到1 这个操作
 */
public class shell_my {
    public int[] shell(int[] numbers) {
        //根据数组长度 确定h
        int h = 1;
        while (h < numbers.length / 2) {
            h = 2 * h + 1;
        }
        while (h >= 1) {
            //排序
            //找到带插入的元素
            for (int i = h; i < numbers.length; i++) {
                //把代插入的元素插入到有序的数列中
                for (int j = i; j >= h; j -= h) {
                    //代插入的元素
                    if (numbers[j] < numbers[j - h]) {
                        int temp = numbers[j];
                        numbers[j] = numbers[j - h];
                        numbers[j - h] = temp;
                    } else {
                        break;
                    }
                }
            }
            //减少h的值
            h = h / 2;
        }
        return numbers;
    }

    @Test
    public void test() {
        int[] numbers = {5, 1, 8, 9, 4, 5, 8, 6};
        for (Integer va : shelltest(numbers)) {
            System.out.println(va);
        }
    }

    public int[] shelltest(int[] numbers) {
        //确定h 的增强的量
        int h = 1;
        while (h < numbers.length / 2) {
            h = 2 * h + 1;
        }
        while (h >= 1) {
            //找到分组的排序的元素 选择插入排序原理
            for (int i = h; i < numbers.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (numbers[j] < numbers[j - h]) {
                        int temp = numbers[j];
                        numbers[j] = numbers[j - h];
                        numbers[j - h] = temp;
                    } else {
                        break;
                    }
                }
            }
            h = h / 2;
        }
        return numbers;
    }
}

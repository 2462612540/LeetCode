/**
 * Copyright (C), 2018-2020
 * FileName: FindContinuousSequence
 * Author:   xjl
 * Date:     2020/5/13 13:30
 * Description: 测试
 */
package 牛客网练习题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        return lists;
    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int count = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                if (count == 1) {
                    num1[0] = array[i];
                    count++;
                }
                if (count == 2) {
                    num2[0] = array[i];
                }
            }
        }
    }

    public int InversePairs(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    count++;
                }
            }
        }
        return count % 1000000007;
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        int count = 1;
        int sum = 0;
        int max = 0;

        while (count <= array.length - 1) {
            for (int i = 0; i <= array.length - count; i++) {

            }
        }
        return 0;
    }

    @Test
    public void test4() {
        int[] array = {6, -3, -2, 7, -15, 1, 2, 2};
        FindGreatestSumOfSubArray(array);

    }

    @Test
    public void test1() {
        int[] array = {364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301, 601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667, 465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557, 67, 746, 550, 474, 162, 268, 142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583, 523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671, 433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};
        int re = InversePairs(array);
        System.out.println(re);
    }

    @Test
    public void test() {
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = {0};
        int[] num2 = {0};
        FindNumsAppearOnce(array, num1, num2);
    }

    @Test
    public void test3() {
        System.out.println(Integer.valueOf("332321") - Integer.valueOf("365245"));

    }
}

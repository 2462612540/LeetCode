/**
 * Copyright (C), 2018-2020
 * FileName: test
 * Author:   xjl
 * Date:     2020/7/30 16:53
 * Description: 考试
 */
package Test_Pricate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main18 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int k = 4;
        int x = -1;
        List<Integer> result = findClosestElements(array, k, x);
        System.out.println(result.toString());
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] array = new int[arr.length];
        //存放插值结果
        for (int i = 0; i < arr.length; i++) {
            array[i] = Math.abs(arr[i] - x);
        }
        //利用的冒泡排序来实现交换元素
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    //交换
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;

                    //交换原来数组的元素
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        //获取前个数据
        for (int i = 0; i < k; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list);
        return list;
    }

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        int size = arr.length;

        int left = 0;
        int right = size - 1;

        int removeNums = size - k;
        while (removeNums > 0) {
            if (x - arr[left] <= arr[right] - x) {
                right--;
            } else {
                left++;
            }
            removeNums--;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}

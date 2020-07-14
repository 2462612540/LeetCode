/**
 * Copyright (C), 2018-2020
 * FileName: Main13
 * Author:   xjl
 * Date:     2020/7/12 13:37
 * Description: 数组的调整
 */
package Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main13 {

    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] array = new int[m];

        for (int i = 0; i < m; i++) {
            array[i] = sc.nextInt();
        }
        //调用
        int[] result = solution(array);
        //结果
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] test(int[] array) {
        int[] result = new int[array.length];

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (!list1.contains(array[i])) {
                list1.add(array[i]);
            } else {
                list2.add(array[i]);
            }
        }
        Collections.sort(list1);
        for (int V : list2) {
            list1.add(V);
        }
        int index = 0;
        for (int V : list1) {
            result[index++] = V;
        }
        return result;
    }

    private static int[] test1(int[] array) {
        for (int i = 1; i <= (array.length + 1) / 2; i++) {
            if (array[i] > array[i - 1]) {
                continue;
            } else {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] > array[i] && array[j] > array[i - 1]) {
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        break;
                    }
                }
            }
        }
        return array;
    }

    private static int[] solution(int[] arr) {
        int l = 0, r = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[r]) {
                swap(arr, r + 1, i);
                r++;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/**
 * Copyright (C), 2018-2020
 * FileName: Main001_double_pointer
 * Author:   xjl
 * Date:     2020/7/6 14:17
 * Description: 双指针
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main001_double_pointer {
    public static void main(String[] args) {
        //数据的输入
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] array = new int[m];
        for (int i = 0; i < m; i++) {
            array[i] = sc.nextInt();
        }
        //函数的调用
        int result = getMinMissNum(array);
        //结果的显示
        System.out.println(result);
    }

    public static int test(int[] array) {
        int res = 1;
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (res != array[i]) {
                return res;
            }
            res++;
        }
        return array[array.length - 1] + 1;
    }

    public static int test2(int[] array) {
        ArrayList<Integer> list = new ArrayList();
        for (int i=0;i<array.length;i++){
            list.add(array[i]);
        }
        //检查
        for (int i=1;i<=array.length;i++){
            if (!list.contains(i)){
                return i;
            }
        }
        return  list.get(list.size()) + 1;
    }

    private static int getMinMissNum(int[] arr) {
        if (arr == null || arr.length == 0) return 1;
        int left = 0;  //目前为止，数组arr已经包含的正整数
        int right = arr.length; //最优情况下，数组可能包含的正整数范围
        while (left < right) {
            if (arr[left] == left + 1) {
                left++;
            } else if (arr[left] <= left || arr[left] > right || arr[arr[left] - 1] == arr[left]) {
                arr[left] = arr[--right];
            } else {
                int tmp = arr[left];
                arr[left] = arr[arr[left] - 1];
                arr[tmp - 1] = tmp;
            }
        }
        return left + 1;
    }
}

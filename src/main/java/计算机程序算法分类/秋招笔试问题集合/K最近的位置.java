/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class K最近的位置 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(",");
        int[] array = new int[str.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.valueOf(str[i]);
        }
        int k = sc.nextInt();
        int x = sc.nextInt();
        List<Integer> res = findClosestElements(array, k, x);
        for (int i = 0; i < res.size(); i++) {
            if (i != res.size() - 1) {
                System.out.print(res.get(i) + ",");
            } else {
                System.out.print(res.get(i));
            }
        }
    }

    public static List<Integer> find(int[] arr, int k, int x) {
        return null;
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(ret, (a, b) -> a == b ? a - b : Math.abs(a - x) - Math.abs(b - x));
        ret = ret.subList(0, k);
        Collections.sort(ret);
        return ret;
    }
}

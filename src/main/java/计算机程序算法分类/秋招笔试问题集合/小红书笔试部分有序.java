/**
 * Copyright (C), 2018-2020
 * FileName: 小红书笔试部分有序
 * Author:   xjl
 * Date:     2020/9/6 19:22
 * Description:
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 小红书笔试部分有序 {

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int[] array2 = new int[n];
        for (int i = 0; i < n; i++) {
            array2[i] = array[i];
        }
        Arrays.sort(array2);
        for (int i = 0; i < n; i++) {
            if (array2[i] != array[i]) {
                ans.add(i);
            }
        }

        if (ans.size() == 0) {
            ans.add(-1);
            ans.add(-1);
        }

        System.out.println(ans.get(0) + " " + ans.get(ans.size() - 1));

    }

    /**
     * 就是采用的两次遍历 就是的分别在左边的位置和右边的位置
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> ans = new ArrayList<>();
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        if (array == null || array.length == 0) ;
        int last = -1, first = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] < max) {
                last = i;
            } else {
                max = Math.max(max, array[i]);
            }

            if (array[len - 1 - i] > min) {
                first = len - 1 - i;
            } else {
                min = Math.min(min, array[len - 1 - i]);
            }
        }
        System.out.println();
    }
}

/**
 * Copyright (C), 2018-2020
 * FileName: MaxStringsum
 * Author:   xjl
 * Date:     2020/7/27 12:57
 * Description: 大数相加的和
 */
package Math;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 18798458748987589654887584
 * 875898748587968489578456984587
 */
public class MaxStringsum {
    public static void main(String[] args) {
        //数据的输入
        Scanner sc = new Scanner(System.in);
        String nums1 = sc.nextLine();
        String nums2 = sc.nextLine();

        //函数的调用
        String result = testmax(nums1, nums2);
        //结果的打印
        System.out.println(result);
    }

    private static String testmax(String nums1, String nums2) {
        nums1 = new StringBuffer(nums1).reverse().toString();
        nums2 = new StringBuffer(nums2).reverse().toString();
        //设置两个相同的数组存放数字
        int[] array1 = new int[nums1.length()];
        int[] array2 = new int[nums2.length()];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = nums1.charAt(i) - '0';
        }
        for (int i = 0; i < array2.length; i++) {
            array2[i] = nums2.charAt(i) - '0';
        }
        //存放结果
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        //进位
        int current = 0;
        int a = 0, b = 0;
        while (i < array1.length || j < array2.length) {
            if (i == array1.length) {
                a = 0;
            } else {
                a = array1[i++];
            }
            if (j == array2.length) {
                b = 0;
            } else {
                b = array2[j++];
            }
            int sum = a + b + current;
            current = sum / 10;
            list.add(sum % 10);
        }
        if (current == 1) {
            list.add(current);
        }
        String res = "";
        for (int V : list) {
            res += String.valueOf(V);
        }
        return new StringBuffer(res).reverse().toString();
    }
}

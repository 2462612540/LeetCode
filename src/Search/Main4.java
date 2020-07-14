/**
 * Copyright (C), 2018-2020
 * FileName: Main4
 * Author:   xjl
 * Date:     2020/7/10 9:17
 * Description: 测试
 */
package Search;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        //输入的数据
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        int[] array1 = new int[m];
        int[] array2 = new int[m];

        for (int i = 0; i < m; i++) {
            array1[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            array2[i] = sc.nextInt();
        }
        //调用函数
        int[] result = test(array1, array2);

        //输出结果
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    private static int[] test(int[] array1, int[] array2) {
        //结果
        int[] result = new int[array1.length];

        int[] nums1 = new int[array1.length * 2];
        int[] nums2 = new int[array1.length * 2];

        for (int i = 0; i < array1.length; i++) {
            nums1[i] = array1[i];
            nums1[i + array1.length] = array1[i];
        }

        for (int i = 0; i < array2.length; i++) {
            nums2[i] = array2[i];
            nums2[i + array2.length] = array2[i];
        }

        //开始遍历
        for (int i = 0; i < nums1.length / 2; i++) {
            int flag = 0;
            int sum = 0;
            for (int j = i; j < i + nums2.length / 2; j++) {
                if (sum + nums1[j] - nums2[j] < 0) {
                    flag = 1;
                    break;
                } else {
                    sum = sum + nums1[j] - nums2[j];
                }
            }
            if (flag == 1) {
                result[i] = 0;
            } else {
                result[i] = 1;
            }
        }
        return result;
    }
}

/**
 * Copyright (C), 2018-2020
 * FileName: 约瑟夫
 * Author:   xjl
 * Date:     2020/9/8 19:28
 * Description:
 */
package 计算机程序算法分类.秋招笔试问题集合;

import org.junit.Test;

public class 约瑟夫 {

    public static int reportNumber(int totalNumber) {
        return test(totalNumber, 3) + 1;
    }

    private static int test(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    @Test
    public static void main(String[] args) {
        int i = reportNumber(4);
        System.out.println(i);
    }

    public int findMaxMatchStringLength(String s1, String s2) {
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        int length1 = s1.length();
        int length2 = s2.length();
        int num = 0;
        for (int j = 0; j < length2; j++) {
            for (int i = 0; i < length1; i++) {
                int len = ((length1 - i) < (length2 - j)) ? (length1 - i - 1) : (length2 - j - 1);
                int tmp = 0;
                for (int k = 0; k < len; k++) {
                    if (array1[i + k] == array2[j + k]) {
                        tmp++;
                    } else {
                        break;
                    }
                }
                if (tmp > num) {
                    num = tmp;
                }
            }
        }
        return num;
    }

}

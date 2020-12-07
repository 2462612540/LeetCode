package 名企高频面试题143; /**
 * Copyright (C), 2018-2020
 * FileName: 最长的连续的公共字串
 * Author:   xjl
 * Date:     2020/10/9 14:01
 * Description:
 */

import java.util.Scanner;

public class 最长连续的公共字串 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        char[] numsA = str1.toCharArray();
        char[] numsB = str2.toCharArray();
        int countinusLen = ContinusLCS(numsA, numsB);
        System.out.println(countinusLen);
    }

    //名企高频面试题143.最长公共字串，最长连续公共子序列+输出最长公共字串，通过endHere
    public static int ContinusLCS(char[] arr1, char[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int maxlen = 0;
        int endHere = 0;//最长公共字串的最后一个位置
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                //如果是位置的是相等于的话
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxlen) {
                        maxlen = dp[i][j];
                        endHere = i;
                    }
                }
            }
        }
        //输出最长公共字串，通过endHere
        for (int i = endHere - maxlen; i < endHere; i++) {
            System.out.print(arr1[i]);
        }
        System.out.println();
        return maxlen;
    }
}

/**
 * Copyright (C), 2018-2020
 * FileName: One_Pack
 * Author:   xjl
 * Date:     2020/9/21 15:31
 * Description:
 */
package 背包问题;

import java.util.Scanner;

public class One_Pack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split(" ");
        int[] array1 = new int[str1.length];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = Integer.valueOf(str1[i]);
        }
        String[] str2 = sc.nextLine().split(" ");
        int[] array2 = new int[str2.length];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = Integer.valueOf(str2[i]);
        }
        int C = sc.nextInt();
        int kapsack = Kapsack(array1, array2, C);
        System.out.println(kapsack);
    }

    public static int Kapsack(int[] W, int[] V, int C) {
        int n = W.length - 1;
        if (n == 0 || C == 0) {
            return 0;
        }
        int[] memo1 = new int[C + 1];
        memo1[0] = 0;
        //看第0个元素的时候
        for (int i = 0; i <= C; i++) {
            memo1[i] = (i >= W[0] ? V[0] : 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = C; j >= W[i]; j--) {
                memo1[j] = Math.max(memo1[j], V[i] + memo1[j - W[i]]);
            }
        }
        return memo1[C];
    }
}
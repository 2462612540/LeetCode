/**
 * Copyright (C), 2018-2020
 * FileName: Main10
 * Author:   xjl
 * Date:     2020/7/12 11:14
 * Description: 最大收益问题
 */
package Search;

import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();
        int K = sc.nextInt();

        int[] costs = new int[N];
        int[] profits = new int[N];

        for (int i = 0; i < N; i++) {
            costs[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            profits[i] = sc.nextInt();
        }

        //调用
        int result = test(costs, profits, W, K);

        //结果
        System.out.println(result);

    }

    private static int test(int[] costs, int[] profits, int w, int k) {
        return 0;
    }
}

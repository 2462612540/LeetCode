/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 秋招笔试问题集合;

import org.junit.Test;

import java.util.Scanner;

public class 多重背包问题 {
    public static void main(String[] args) {

        //数据的输入
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//
        int V = sc.nextInt();//表示的V 表示的总的容量
        sc.nextLine();
        int[] weight = new int[N];
        int[] value = new int[N];
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            String[] s = sc.nextLine().split(" ");
            weight[i] = Integer.valueOf(s[0]);
            value[i] = Integer.valueOf(s[1]);
            num[i] = Integer.valueOf(s[2]);
        }
        //函数的调用
        int multiplepack = multiplepack(V, N, weight, value, num);
        //结果
        System.out.println(multiplepack);
    }

    /**
     * 第二类背包：多重背包 :每类物品都有个数限制，第i类物品最多可以装num[i]次
     *
     * @param V
     * @param N
     * @param weight
     * @param value
     * @param num
     * @return
     */
    public static int multiplepack(int V, int N, int[] weight, int[] value, int[] num) {
        //初始化动态规划数组
        int[][] dp = new int[N + 1][V + 1];
        //为了便于理解,将dp[i][0]和dp[0][j]均置为0，从1开始计算
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                //如果第i件物品的重量大于背包容量j,则不装入背包
                //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if (weight[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else {
                    //考虑物品的件数限制
                    int maxV = Math.min(num[i - 1], j / weight[i - 1]);
                    for (int k = 0; k < maxV + 1; k++) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - k * weight[i - 1]] + k * value[i - 1]);
                    }
                }
            }
        }
        return dp[N][V];
    }

    @Test
    public void test() {
        System.out.println(Math.pow(2, 60) - Math.pow(10, 9));
    }
}


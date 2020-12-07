/**
 * Copyright (C), 2018-2020
 * FileName: 爬楼梯
 * Author:   xjl
 * Date:     2020/9/6 10:20
 * Description:
 */
package 深度优先广度优先问题;

import java.util.Scanner;

/**
 * dp1[i] = dp[i - 1] + dp2[i - 1]
 * dp2[i] = dp1[i - 2]
 * print(dp1[-1] + dp2[-1])
 * ----------------------------------
 * dn[i][0]=dn[i-1][0]+dn[i-1][1],
 * dn[i][1]=dn[i-2][0]
 */
public class 爬楼梯 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float[][] dp = new float[105][3];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[2][1] = 1;
        for (int i = 3; i < 105; i++) {
            dp[i][1] = dp[i][1] + dp[i - 1][2] + dp[i - 1][1];
            dp[i][2] = dp[i][2] + dp[i - 2][1];
        }
        System.out.println(dp[n][1] + dp[n][2]);
    }
}

/**
 * Copyright (C), 2018-2020
 * FileName: 背包问题01问题
 * Author:   xjl
 * Date:     2020/9/13 14:28
 * Description:
 */
package 计算机程序算法分类.动态规划问题集合;

import java.util.Arrays;
import java.util.Scanner;

public class 背包问题多重背包 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[] array=new int[n];
        for (int i=0;i<n;i++){
            array[i]=sc.nextInt();
        }
        int res=test12(m,array);
        if (res==Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(res);
        }
    }

    private static int test12(int m, int[] n) {
        Arrays.sort(n);
        int[] dp=new int[m+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (int i=0;i<n.length;i++){
            for (int j=n[i];j<=m;j++){
                dp[j]=Math.min(dp[j],dp[j-n[i]]);
            }
        }
        return dp[m];
    }

    public static int completePack3(int V, int N, int[] weight, int[] value) {
        //动态规划
        int[] dp = new int[V + 1];
        for (int i = 1; i < N + 1; i++) {
            //顺序实现
            for (int j = weight[i - 1]; j < V + 1; j++) {
                dp[j] = Math.max(dp[j - weight[i - 1]] + value[i - 1], dp[j]);
            }
        }
        return dp[V];
    }

}

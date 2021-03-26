package testcode;

import java.util.Scanner;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2021/3/24 15:44
 * @Created by xjl
 */
public class Main {

    public static void main(String[] args) {
        //数据的读入
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();

        int N = sc.nextInt();

        int[] weight = new int[N];
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = weight[i];
            weight[i] = 1;
        }
        int[] arr1 = new int[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }
        int[] arr2 = new int[N];
        for (int i = 0; i < N; i++) {
            arr2[i] = sc.nextInt();
        }



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
}

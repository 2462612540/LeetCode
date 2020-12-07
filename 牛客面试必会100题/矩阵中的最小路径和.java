/**
 * Copyright (C), 2018-2020
 * FileName: 矩阵中的最小路径和
 * Author:   xjl
 * Date:     2020/10/5 19:37
 * Description:
 */
package 牛客面试必会100题;

import org.junit.Test;

public class 矩阵中的最小路径和 {

    public int minPathSum(int[][] matrix) {
        int m = matrix.length;//行
        int n = matrix[0].length;//列
        int[][] dis = new int[m][n];
        dis[0][0] = matrix[0][0];
        //行
        for (int i = 1; i < n; i++) {
            dis[0][i] = dis[0][i - 1] + matrix[0][i];
        }
        //列
        for (int i = 1; i < m; i++) {
            dis[i][0] = dis[i - 1][0] + matrix[i][0];
        }
        //判断
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dis[i - 1][j] > dis[i][j - 1]) {
                    dis[i][j] = matrix[i][j] + dis[i][j - 1];
                } else {
                    dis[i][j] = matrix[i][j] + dis[i-1][j];
                }
            }
        }
        return dis[m-1][n-1];
    }

    @Test
    public void test() {
        int[][] array = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        int i = minPathSum(array);
        System.out.println(i);
    }
}

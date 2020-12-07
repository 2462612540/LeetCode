/**
 * Copyright (C), 2018-2020
 * FileName: 螺旋矩阵II
 * Author:   xjl
 * Date:     2020/10/1 9:45
 * Description:
 */
package 牛客面试必会100题;

import org.junit.Test;

public class 螺旋矩阵II {

    @Test
    public void test() {
        int[][] ints = generateMatrix(3);
        for (int[] a : ints) {
            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    /**
     * 填充数字
     *
     * @param n
     * @return
     */

    public int[][] generateMatrix(int n) {
        if (n == 0) return new int[][]{};
        int[][] arry = new int[n][n];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        boolean[][] vis = new boolean[n][n];
        int d = 0;
        int x = 0;
        int y = 0;
        for (int i = 1; i <= n * n; i++) {
            arry[x][y] = i;
            vis[x][y] = true;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !vis[nx][ny]) {
                x = nx;
                y = ny;
            } else {
                d = (d + 1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
                x = nx;
                y = ny;
            }
        }
        return arry;
    }
}

/**
 * Copyright (C), 2018-2020
 * FileName: movingCount13
 * Author:   xjl
 * Date:     2020/6/3 9:46
 * Description: 机器人的运动
 */
package leetcode练习题;

public class movingCount13 {
    int sum;
    int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int movingCount(int threshold, int rows, int cols) {
        sum = 0;
        boolean[][] visit = new boolean[rows][cols];
        solve(0, 0, rows, cols, visit, threshold);
        return sum;
    }

    //求解的数位之和的结果是多少
    private int cul(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    private void solve(int x, int y, int rows, int cols, boolean[][] visit, int threshold) {
        //递归终止的条件
        if (x < 0 || y < 0 || x >= rows || y >= cols || visit[x][y] || (cul(x) + cul(y)) > threshold) {
            return;
        }
        //当前位置都是可以走的 那就标记访问 那就可以开始向四个方向都可以开始访问的
        //递归函数
        visit[x][y] = true;
        sum++;
        for (int i = 0; i < 4; i++) {
            int newx = x + d[i][0];
            int newy = y + d[i][1];
            solve(newx, newy, rows, cols, visit, threshold);
        }
    }

    public int movingCount2(int m, int n, int k) {
        sum = 0;
        boolean[][] visit = new boolean[m][n];
        solve(0, 0, m, n, visit, k);
        return sum;
    }
}

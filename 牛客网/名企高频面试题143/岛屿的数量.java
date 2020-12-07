package 名企高频面试题143; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.岛屿的数量
 * Author:   xjl
 * Date:     2020/9/23 21:33
 * Description:
 */


/**
 * 采用的是深度优先搜索的 是的栈溢出的效果
 */
public class 岛屿的数量 {

    //记录矩阵的行列
    static int row, col;
    //记录好是否访问
    static boolean[][] vis;
    //记录好四个方向
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static int solve(char[][] grid) {
        //判断矩阵
        row = grid.length;
        if (row == 0) {
            return 0;
        }
        col = grid[0].length;
        vis = new boolean[row][col];
        //记录岛屿的数量
        int amount = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //保证是 1且没有被访问过
                if (!vis[i][j] && grid[i][j] == '1') {
                    amount++;
                    //这里不需要进行回溯的，只需要的是的判断时候遍历没有
                    dfstest(grid, i, j);
                }
            }
        }
        return amount;
    }

    //开始进行深度遍历
    private static void dfstest(char[][] grid, int i, int j) {
        vis[i][j] = true;
        //开始访问四个方向
        for (int k = 0; k < 4; k++) {
            int nx = i + d[k][0];
            int ny = j + d[k][1];
            // 如果不越界、没有被访问过、并且还要是陆地
            if (Area(nx, ny) && grid[nx][ny] == '1' && !vis[nx][ny]) {
                dfstest(grid, nx, ny);
            }
        }
    }

    private static boolean Area(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}

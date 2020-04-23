/**
 * Copyright (C), 2018-2020
 * FileName: numIslands
 * Author:   xjl
 * Date:     2020/4/20 8:13
 * Description: DFS
 */
package Leetcode_Medium_difficulty;

/**
 * 深度优先遍历的算法题目
 */
public class numIslands {
    private int result = 0;
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    //如果是等于0的话那就继续下一个走
                    continue;
                } else {
                    //如果是等于1的话那就进入DFS遍历
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            //超出圈的范围
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        if (grid[i][j] == '1') {
            //第一步就是将设置为0
            grid[i][j] = '0';
            //然后在去寻找上下左右四个位置
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }

    public int numIslands2(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if (n <= 0 || m <= 0) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    DFS(grid, i, j);
                    result++;
                } else {
                    continue;
                }
            }
        }
        return result;
    }

    private void DFS(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > m || j > n) {
            //如果是超出范围的话那就
            return;
        }
        if (grid[i][j] == '0') {
            //如果是0的话也是返回
            return;
        }
        if (grid[i][j] == '1') {
            //如果是1的话那就设置为0，否则就设置为0 然后咋遍历上下左右的数据
            grid[i][j] = '0';
            DFS(grid, i + 1, j);
            DFS(grid, i - 1, j);
            DFS(grid, i, j + 1);
            DFS(grid, i, j - 1);
        }
    }
}

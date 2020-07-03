/**
 * Copyright (C), 2018-2020
 * FileName: maxAreaOfIsland695
 * Author:   xjl
 * Date:     2020/7/2 14:46
 * Description: 695
 *
 */
package Graph;

import org.junit.Test;

public class maxAreaOfIsland695 {
    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        //首先先检查数组书否合适
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    result = Math.max(result, dfs(grid,i,j,visited));
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        //访问这个点
        visited[i][j] = true;
        int area = 1;
        //child
        for (int[] DIR : DIRS) {
            int newRow = i + DIR[0];
            int newCol = j + DIR[1];
            //判断的这几个是否是在矩阵内部和二维矩阵和是否访问过了
            if (checkBoundary(grid, newRow, newCol) && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                area += dfs(grid, newRow, newCol, visited);
            }
        }
        return area;
    }

    private boolean checkBoundary(int[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        return i >= 0 && i < row && j >= 0 && j < col;
    }

    @Test
    public void test() {

    }
}

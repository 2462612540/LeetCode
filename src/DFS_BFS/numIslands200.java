/**
 * Copyright (C), 2018-2020
 * FileName: numIslands200
 * Author:   xjl
 * Date:     2020/8/11 15:30
 * Description: 岛屿的数量
 */
package DFS_BFS;

public class numIslands200 {
    //保存行列的数值
    int m;
    int n;
    // 方向数组，它表示了相对于当前位置的 4 个方向的横、纵坐标的偏移量，这是一个常见的技巧
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    // 标记数组，标记了 grid 的坐标对应的格子是否被访问过
    private boolean[][] marked;

    public int numIslands(char[][] grid) {
       int result = 0;
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        m = grid.length;//行
        n = grid[0].length;//列
        //表示没有访问
        marked = new boolean[m][n];
        //开始遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //如果是遍历等于1表示的陆地
                if (grid[i][j] == '1' && !marked[i][j]) {
                    dfs(grid, i, j);
                    //表示有一个陆地
                    result++;
                } else {
                    continue;
                }
            }
        }
        return result;
    }

    public int numIslands1(char[][] grid) {
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        //赋值都是false
        marked = new boolean[m][n];
        //统计数量
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果是岛屿中的一个点，并且没有被访问过。就进行深度优先遍历
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    // 从坐标为 (i,j) 的点开始进行深度优先遍历
    private void dfs(char[][] grid, int i, int j) {
        //表示访问过了
        marked[i][j] = true;
        // 得到 4 个方向的坐标
        for (int k = 0; k < 4; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];
            // 如果不越界、没有被访问过、并且还要是陆地
            if (inArea(newX, newY) && grid[newX][newY] == '1' && !marked[newX][newY]) {
                dfs(grid, newX, newY);
            }
        }
    }

    // 判断是否越界
    private boolean inArea(int x, int y) {
        // 等于号不要忘了
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}

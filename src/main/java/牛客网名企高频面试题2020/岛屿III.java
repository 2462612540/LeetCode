package 牛客网名企高频面试题2020;

/**
 * @Classname 岛屿III
 * @Description TODO
 * @Date 2020/12/16 10:40
 * @Created by xjl
 */
public class 岛屿III {
    boolean[][] vis;
    int row, cloum;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int solve(char[][] grid) {
        row = grid.length;
        if (row == 0) return 0;
        cloum = grid[0].length;
        vis = new boolean[row][cloum];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cloum; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, vis);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y, boolean[][] vis) {
        vis[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && ny >= 0 && nx < row && ny < cloum && !vis[nx][ny] && grid[nx][ny] == '1') {
                dfs(grid, nx, ny, vis);
            }
        }
    }

}

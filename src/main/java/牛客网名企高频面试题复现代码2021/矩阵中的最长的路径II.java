package 牛客网名企高频面试题复现代码2021;

/**
 * @Classname 矩阵中的最长的路径II
 * @Description TODO
 * @Date 2020/12/16 9:22
 * @Created by xjl
 */
public class 矩阵中的最长的路径II {
    int[][] dp;
    int row, cloum;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int len(int[][] martix) {
        int res = 1;
        row = martix.length;
        if (row == 0) return 0;
        cloum = martix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cloum; j++) {
                res = Math.max(res, dfs(martix, i, j));
            }
        }
        return res;
    }

    private int dfs(int[][] martix, int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dx[i];
            if (nx >= 0 && ny >= 0 && nx < row && ny < cloum && martix[nx][ny] > martix[x][y]) {
                dp[x][y] = Math.max(dp[x][y], 1 + dfs(martix, nx, ny));
            }
        }
        return dp[x][y];
    }
}

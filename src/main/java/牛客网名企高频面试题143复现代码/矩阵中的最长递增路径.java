package 牛客网名企高频面试题143复现代码;

/**
 * @Classname 矩阵中的最长递增路径
 * @Description TODO
 * @Date 2020/12/15 16:34
 * @Created by xjl
 */
public class 矩阵中的最长递增路径 {

    int[][] dp;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int row, cloum;

    public int length(int[][] matrix) {
        row = matrix.length;
        if (row == 0) return 0;
        cloum = matrix[0].length;
        dp = new int[row][cloum];
        int max = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cloum; j++) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        //当前的状态
        dp[x][y] = 1;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < row && ny >= 0 && ny < cloum && matrix[nx][ny] > matrix[x][y]) {
                dp[x][y] = Math.max(dp[x][y], 1 + dfs(matrix, nx, ny));
            }
        }
        return dp[x][y];
    }
}

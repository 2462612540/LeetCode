package 名企高频面试题143;

/**
 * @Classname 矩阵中递增的路径
 * @Description TODO
 * @Date 2020/12/15 15:27
 * @Created by xjl
 */
public class 矩阵中递增的路径 {

    int[][] dp;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    int m, n;

    public int solve(int[][] matrix) {
        int max = 1;
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int x, int y) {
        //终止条件
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        //当前的状态
        dp[x][y] = 1;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] > matrix[x][y]) {
                //下一个时刻的状态
                dp[x][y] = Math.max(dp[x][y], 1 + dfs(matrix, nx, ny));
            }
        }
        return dp[x][y];
    }
}

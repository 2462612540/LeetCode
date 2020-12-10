package 名企高频面试题143;

import org.junit.Test;

/**
 * @Classname 矩阵的乘法
 * @Description TODO
 * @Date 2020/12/10 18:59
 * @Created by xjl
 */
public class 矩阵的乘法 {
    public int[][] solve(int[][] a, int[][] b) {
        int m = a.length;//A的行数
        int p = a[0].length;//A的列数=B的行数
        int n = b[0].length;//B的行数
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int t = 0;
                for (int k = 0; k < p; k++) {
                    t += a[i][k] * b[k][j];
                }
                ans[i][j] = t;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        solve(new int[][]{{1, 2}, {3, 2}}, new int[][]{{3, 4}, {2, 1}});
    }
}

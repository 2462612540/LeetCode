package 牛客网名企高频面试题;

import org.junit.Test;

/**
 * @Classname 路径的和II
 * @Description TODO
 * @Date 2020/12/18 14:37
 * @Created by xjl
 */
public class 路径方式数量 {
    public int uniquePaths(int m, int n) {
        int[][] martix = new int[m][n];
        //赋值为1
        for (int i = 0; i < n; i++) {
            martix[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            martix[i][0] = 1;
        }
        //求解
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                martix[i][j] = martix[i - 1][j] + martix[i][j - 1];
            }
        }
        return martix[m - 1][n - 1];
    }

    @Test
    public void test() {
        int i = uniquePaths(2, 1);
        System.out.println(i);
    }
}

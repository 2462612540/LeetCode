package leetode每日一题;

/**
 * @Classname 奇怪的打印机664
 * @Description TODO
 * @Date 2021/5/24 20:45
 * @Created by xjl
 */
public class 奇怪的打印机664 {

    public int strangePrinter(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            //对角线上是一致的都是的打印一次应为对角线的元素是相同的
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                //如果是相同的就是求解子问题
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i][j - 1];
                } else {
                    //如果不是相同的话 那就分两段的来判断来实现的 （i,k） (k,j)两个的和与最小的进行比较判断
                    int minn = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        minn = Math.min(minn, f[i][k] + f[k + 1][j]);
                    }
                    f[i][j] = minn;
                }
            }
        }
        return f[0][n - 1];
    }
}

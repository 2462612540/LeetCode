package 牛客网名企面试笔试代码复现2021;

/**
 * @Classname 数字的划分
 * @Description TODO
 * @Date 2021/3/8 10:42
 * @Created by xjl
 */
public class 数字的划分 {
    /**
     * @description TODO  数字的划分和分糖果是一样的 有n 个糖果 分给k小小朋友 问有多少中分发多少个糖果
     * @param: n
     * @param: k
     * @date: 2021/3/8 10:43
     * @return: int
     * @author: xjl
     */
    private int count = 0;

    public int diver(int n, int k) {
        dfs(1, n, k);
        return count;
    }

    public void dfs(int i, int n, int k) {
        if (n < i) return;
        if (k == 1) {
            System.out.println(i + " " + " " + n + " " + k);
            count++;
            return;
        }
        while (i <= n) {
            dfs(i, n - i, k - 1);
            i++;
        }
    }
}

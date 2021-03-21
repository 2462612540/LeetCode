package 牛客网名企面试笔试代码复现2021;

/**
 * @Classname GCD辗转相除
 * @Description TODO
 * @Date 2021/2/27 10:40
 * @Created by xjl
 */
public class GCD辗转相除 {
    public int GCD(int m, int n) {
        int res = 0;
        while (n != 0) {
            res = m % n;
            m = n;
            n = res;
        }
        return m;
    }
}

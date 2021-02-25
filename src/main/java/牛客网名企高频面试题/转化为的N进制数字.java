package 牛客网名企高频面试题;

import org.junit.Test;

/**
 * @Classname 转化为的Nj进制数字
 * @Description TODO
 * @Date 2020/12/12 17:59
 * @Created by xjl
 */
public class 转化为的N进制数字 {

    public String solve(int M, int N) {
        if (M == 0) return "0";
        String s = "0123456789ABCDEF";
        String res = "";
        boolean f = false;
        if (M < 0) {
            f = true;
            M = -M;
        }
        while (M != 0) {
            res += s.charAt(M % N);
            M /= N;
        }
        if (f) res += "-";
        StringBuffer sb = new StringBuffer(res);
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        String solve = solve(7, 2);
        System.out.println(solve);
    }
}

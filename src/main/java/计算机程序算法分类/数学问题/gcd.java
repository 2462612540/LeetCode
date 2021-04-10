package 计算机程序算法分类.数学问题;

/**
 * @Classname gcd
 * @Description TODO
 * @Date 2021/4/10 13:04
 * @Created by xjl
 */
public class gcd {

    private long gcd(long x, long y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}

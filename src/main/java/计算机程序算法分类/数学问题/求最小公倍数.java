package 计算机程序算法分类.数学问题;

/**
 * @Classname 求最小公倍数
 * @Description TODO
 * @Date 2021/4/10 13:04
 * @Created by xjl
 */
public class 求最小公倍数 {

    // 求最大公约数
    private long gcd(long x, long y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    // 求最小公倍数
    private long lcm(long x, long y) {
        return (x * y) / gcd(x, y);
    }
}

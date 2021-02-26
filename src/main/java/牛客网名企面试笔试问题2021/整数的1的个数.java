package 牛客网名企面试笔试问题2021;

/**
 * @Classname 整数的1的个数
 * @Description TODO
 * @Date 2021/2/26 11:06
 * @Created by xjl
 */
public class 整数的1的个数 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}

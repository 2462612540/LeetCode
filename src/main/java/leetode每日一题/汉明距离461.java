package leetode每日一题;

import org.junit.Test;
import 牛客网练习题.Solution;

/**
 * @Classname 汉明距离461
 * @Description TODO
 * @Date 2021/5/27 9:31
 * @Created by xjl
 */
public class 汉明距离461 {
    /**
     * @description TODO  大多数编程语言都内置了计算二进制表达中 1 的数量的函数。在工程中，我们应该直接使用内置函数
     * @param: x
     * @param: y
     * @date: 2021/5/27 9:31
     * @return: int
     * @author: xjl
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
    /**
     * @description TODO 我们可以不断地检查 sss 的最低位，如果最低位为 1，那么令计数器加一，然后我们令 s 整体右移一位，这样 s 的最低位将被舍去，
     * 原本的次低位就变成了新的最低位。我们重复这个过程直到 s=0为止。这样计数器中就累计了 s 的二进制表示中 1的数量。
     *
     * @param: x
     * @param: y
     * @date: 2021/5/27 9:45
     * @return: int
     * @author: xjl
    */
    public int hammingDistance2(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;//向右边移动一位
        }
        return ret;
    }
}

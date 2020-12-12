package 名企高频面试题143;

import org.junit.Test;

/**
 * @Classname 阶乘问题
 * @Description TODO
 * @Date 2020/12/12 16:39
 * @Created by xjl
 */
public class 阶乘问题 {
    /**
     * @description TODO  阶乘结果的0和乘数的2和5有关，而2的个数远多于5，所以只要数5。而5，25，125的倍数是自相似的，所以可以用递归。时间复杂度O(logN)。
     * @param: n
     * @date: 2020/12/12 16:41
     * @return: long
     * @author: xjl
     */
    public long thenumberof0(long n) {
        long res = 0;
        while (n > 0) {
            n /= 5;
            res += n;
        }
        return res;
    }

    /**
     * @description TODO 数组中的1的个数
     * @param: n
     * @date: 2020/12/12 16:44
     * @return: long
     * @author: xjl
     */
    public long thenumberof1(int n) {
        int res = n;
        int count = 0;
        while (res != 0) {
            count++;
            res = res & (res - 1);
        }
        return count;
    }

    @Test
    public void test() {
        long l = thenumberof0(5);
        System.out.println(l);
    }
}

package leetode每日一题;

import org.junit.Test;

/**
 * @Classname 丑数
 * @Description TODO
 * @Date 2021/4/10 10:01
 * @Created by xjl
 */
public class 丑数263 {
    /**
     * @description TODO 时间复杂度为：logn
     * @param: n
     * @date: 2021/4/10 10:23
     * @return: boolean
     * @author: xjl
     */
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }

    public boolean isUgly2(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0){
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }


    @Test
    public void test() {
        boolean ugly = isUgly2(14);
        System.out.println(ugly);
    }
}

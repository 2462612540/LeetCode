package 牛客网名企面试笔试问题2021;

import org.junit.Test;

/**
 * @Classname 斐波莱切数列
 * @Description TODO
 * @Date 2021/3/26 9:41
 * @Created by xjl
 */
public class 斐波莱切数列 {
    /**
     * @description TODO  利用的非递归的方法  一定要注意的好判断的n的条件
     * @param: n
     * @date: 2021/3/26 9:41
     * @return: int
     * @author: xjl
     */
    public int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i < result.length; i++) {
            result[i] = result[i - 2] + result[i - 1];
        }
        return result[n];
    }

    public int Fibonacci2(int n) {
        //递归的出口
        if (n < 2) {
            return n;
        }
        //递归的条件
        return Fibonacci2(n - 2) + Fibonacci2(n - 1);
    }

    @Test
    public void test() {
        int fibonacci = Fibonacci2(3);
        System.out.println(fibonacci);
    }
}

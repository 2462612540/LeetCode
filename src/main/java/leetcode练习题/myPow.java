/**
 * Copyright (C), 2018-2020
 * FileName: myPow
 * Author:   xjl
 * Date:     2020/3/15 15:35
 * Description: 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
package leetcode练习题;

import org.junit.Test;

public class myPow {
    public double myPow(double x, int n) {
        double res = 1.0;
        for(int i = n; i != 0; i /= 2){
            if(i % 2 != 0){
                res *= x;
            }
            x *= x;
        }
        return  n < 0 ? 1 / res : res;
    }
    @Test
    public void test(){
        System.out.println(myPow(2,10));
    }
}

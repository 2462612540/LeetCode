/**
 * Copyright (C), 2018-2020
 * FileName: trailingZeroes
 * Author:   xjl
 * Date:     2020/3/3 9:25
 * Description: 给定一个整数 n，返回 n! 结果尾数中零的数量。
 */
package simple_difficulty;

public class trailingZeroes {
    /**
     * 容易出现在求阶乘的时候出现溢出的操作
     * @param n
     * @return
     */
    public static int trailingZeroes(int n) {
        double sum = 1;
        int count = 0;
        if (n < 0) {//判断传入数是否为负数
            throw new IllegalArgumentException("必须为正整数!");//抛出不合理参数异常
        }
        for (int i = 1; i <= n; i++) {//循环num
            sum *= i;//每循环一次进行乘法运算
        }
        System.out.println("sum="+sum);
        while ((sum / 10) != 0 && sum % 10 == 0) {
            count++;
            sum = sum / 10;
        }
        return count;//零的个数
    }

    public static void main(String[] args) {
        int n = trailingZeroes(13);
        System.out.println(n);
    }
}

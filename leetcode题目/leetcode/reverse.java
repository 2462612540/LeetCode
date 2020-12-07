/**
 * Copyright (C), 2018-2020
 * FileName: reverse
 * Author:   xjl
 * Date:     2020/2/28 16:54
 * Description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 注意:  假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
package leetcode;

/**
 * 1 排除那些不符合的输入的数字
 * 2 将倒序的数据在每次取后面的数字 将这个数字存放在list中 考虑到:1230/901000/超级大的数字
 * 3在计算的时候验证时候超越范围了。
 */
public class reverse {
    public static int reverse(int x) {
        long result = 0;
        //将数字分别取出来放入在list中
        do {
            result = result * 10 + (x % 10);//这里加1后突破了int类型
            x = x / 10;//取出剩下的结果放入x中
            if(result> Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            {
                return 0;
            }
        } while (x != 0);
        return (int)result;
    }

    public static int reverse2(int x){
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }

    public static void main(String[] args) {
        int x = 1534236469;
        int result = reverse(x);
        System.out.println(result);
    }
}

/**
 * Copyright (C), 2018-2020
 * FileName: fib
 * Author:   xjl
 * Date:     2020/3/1 14:11
 * Description: 斐波那契数
 */
package leetcode练习题;

/**
 * 数列
 */
public class fib {
    public static int fib(int N) {
        if(N==0){return 0;}
        if(N<=2){return 1;}
        int a=1,b=1;
        int sum=0;
        for(int i=0;i<N-2;i++){
            sum=a+b;
            a=b;
            b=sum;
        }
        return sum;
    }

    public static int fib2(int N) {
        if(N==1){return 1;}
        int a=0,b=1;
        int sum=0;
        for(int i=0;i<N-1;i++){
            sum=a+b;
            a=b;
            b=sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fib2(1));
    }
}

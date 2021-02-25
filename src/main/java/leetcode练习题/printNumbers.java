/**
 * Copyright (C), 2018-2020
 * FileName: printNumbers
 * Author:   xjl
 * Date:     2020/3/5 12:24
 * Description: 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
package leetcode练习题;

public class printNumbers {
    public static int[] printNumbers(int n) {
        int sum=0;
        for(int i=1;i<=n;i++){
            sum=10*sum+9;
        }
        int[] numbers = new int[sum];
        for (int i=0;i<sum;i++){
            numbers[i]=i+1;
            System.out.println(numbers[i]);
        }
        return numbers;
    }

    public static void main(String[] args) {
        printNumbers(3);
    }
}

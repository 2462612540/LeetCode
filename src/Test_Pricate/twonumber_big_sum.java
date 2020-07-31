/**
 * Copyright (C), 2018-2020
 * FileName: twonumber_big_sum
 * Author:   xjl
 * Date:     2020/7/28 19:52
 * Description: 4
 */
package Test_Pricate;

import java.util.Scanner;

public class twonumber_big_sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double a = sc.nextDouble();
        Double b = sc.nextDouble();

        //调用函数
        Double result = test(a, b);

        //打印结果
        System.out.println(result);
    }

    private static Double test(Double a, Double b) {
        Double sum = 0.0;

        if (a < b) {
            for (int i=1;i<a;i++){
                sum+=a/i;
            }
        } else if (a >= b) {
            for (int i=1;i<=b;i++){
                sum+=a/i;
            }
        }
        return sum;
    }
}

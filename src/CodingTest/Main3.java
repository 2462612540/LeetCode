/**
 * Copyright (C), 2018-2020
 * FileName: test1
 * Author:   xjl
 * Date:     2020/4/22 10:45
 * Description: 测试Io的交集
 */
package CodingTest;

import java.util.Scanner;

/**
 * java总的各种的输入的模板
 */
public class Main3 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //输入数据
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[] number1 = new int[m];

            //存入两个数组
            for (int i = 0; i < m; i++) {
                number1[i] = sc.nextInt();
            }

        }
        sc.close();
    }
}



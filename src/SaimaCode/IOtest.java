/**
 * Copyright (C), 2018-2020
 * FileName: IOtest
 * Author:   xjl
 * Date:     2020/4/22 10:40
 * Description: 输入输出测试
 */
package SaimaCode;

import java.util.Scanner;

public class IOtest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m;
        // 读取输入，直到没有整型数据可读
        while (scanner.hasNextInt()) {
            // 读取N 和 M
            m = scanner.nextInt();
            String[] str = new String[m+1];
            // 读取接下来M行
            for (int i = 0; i < m+1; i++) {
                str[i] = scanner.nextLine();
            }
            for (int i = 0; i < m+1; i++) {
                System.out.println(str[i]);
            }
            System.out.println(str[str.length-1]);
        }
    }
}

/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/13 19:18
 * Description: 排序问题
 */
package Sort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] array = new int[m];

        for (int i = 0; i < m; i++) {
            array[i] = sc.nextInt();
        }
        //调用
        Arrays.sort(array);
        //输出
        for (int V:array){
            System.out.print(V+" ");
        }
    }
}

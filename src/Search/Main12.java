/**
 * Copyright (C), 2018-2020
 * FileName: Main12
 * Author:   xjl
 * Date:     2020/7/12 13:26
 * Description: 自然数组的排序
 */
package Search;

import java.util.Arrays;
import java.util.Scanner;

public class Main12 {

    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        int[] array = new int[m];
        for (int i = 0; i < m; i++) {
            array[i] = sc.nextInt();
        }
        //函数
        Arrays.sort(array);
        //结果
        for (int V : array) {
            System.out.print(V + " ");
        }
    }



}

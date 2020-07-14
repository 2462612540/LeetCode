/**
 * Copyright (C), 2018-2020
 * FileName: Main5
 * Author:   xjl
 * Date:     2020/7/10 11:00
 * Description: 最小的k个数
 */
package Search;

import java.util.Arrays;
import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        //输入数据
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] array = new int[m];
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            array[i] = sc.nextInt();
        }
        //函数调用
        int[] result = test(array, n);
        //显示结果
        for (int V : result) {
            System.out.println(V);
        }
    }

    private static int[] test(int[] array, int n) {
        int[] result = new int[n];
        Arrays.sort(array);
        for (int i = 0; i < n; i++) {
            result[i] = array[i];
        }
        return result;
    }
}

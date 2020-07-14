/**
 * Copyright (C), 2018-2020
 * FileName: Main3
 * Author:   xjl
 * Date:     2020/7/13 19:29
 * Description: 排序问题
 */
package Sort;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] array = new int[m];

        sc.nextLine();
        for (int i = 0; i < m; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        int result = 0;
        for (int i = 1; i < m; i++) {
            result = result > array[i] - array[i - 1] ? result : array[i] - array[i - 1];
        }
        System.out.println(result);
    }
}

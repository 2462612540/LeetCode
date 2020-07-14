/**
 * Copyright (C), 2018-2020
 * FileName: Main9
 * Author:   xjl
 * Date:     2020/7/11 22:14
 * Description: 最大的仙姑的收益
 */
package Search;

import java.util.Arrays;
import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] array = new int[m];
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }


    }
}

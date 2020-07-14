/**
 * Copyright (C), 2018-2020
 * FileName: Main8
 * Author:   xjl
 * Date:     2020/7/11 21:31
 * Description: 排序问题
 */
package Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] array1 = new int[m];
        int[] array2 = new int[m];
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            array1[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            array2[i] = sc.nextInt();
        }

        //函数的调用
        int[] result = test(array1, array2, k);
        //输出
        for (int V:result){
            System.out.print(V+" ");
        }
    }

    private static int[] test(int[] array1, int[] array2, int k) {
        int[] result = new int[k];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                list.add(array1[i] + array2[j]);
            }
        }
        Collections.sort(list);
        int index = 0;
        //存储数据
        for (int i = list.size() - 1; i >= 0; i--) {
            result[index++] = list.get(i);
            if (index == k) {
                break;
            }
        }
        return result;
    }
}

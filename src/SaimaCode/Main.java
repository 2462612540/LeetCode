/**
 * Copyright (C), 2018-2020
 * FileName: test1
 * Author:   xjl
 * Date:     2020/4/22 10:45
 * Description: 测试Io的交集
 */
package SaimaCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            //数据的输入
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int[] data1 = new int[n1];
            int[] data2 = new int[n2];
            List<Integer> result = new ArrayList<>();
            for (int j = 0; j < n1; j++)
                data1[j] = sc.nextInt();
            for (int j = 0; j < n2; j++)
                data2[j] = sc.nextInt();
            System.out.println(n1+"-----------"+n2);
            System.out.println("data1"+data1.toString());
            System.out.println("data2"+data2.toString());
            //调用函数
            result = test(data1, data2, n1, n2);
            //数据的输出
            for (int j = 0; j < result.size() - 1; j++)
                System.out.print(result.get(j) + " ");
            System.out.println(result.get(result.size() - 1));
        }
    }

    private static ArrayList<Integer> test(int[] data1, int[] data2, int n1, int n2) {
        ArrayList<Integer> result = new ArrayList<>();
        int i1 = 0, i2 = 0;
        while (i1 < n1 && i2 < n2) {
            if (data1[i1] < data2[i2])
                result.add(data1[i1++]);
            else if (data1[i1] > data2[i2])
                result.add(data2[i2++]);
            else {
                result.add(data1[i1]);
                i1++;
                i2++;
            }
        }
        while (i1 < n1)
            result.add(data1[i1++]);
        while (i2 < n2)
            result.add(data2[i2++]);
        return result;
    }
}


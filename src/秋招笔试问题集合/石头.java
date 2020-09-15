/**
 * Copyright (C), 2018-2020
 * FileName: 石头
 * Author:   xjl
 * Date:     2020/9/14 21:18
 * Description:
 */
package 秋招笔试问题集合;

import java.util.Arrays;
import java.util.Random;

public class 石头 {
    public static void main(String[] args) {
        int[] array = test(10, 5);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] test(int n, int k) {
        int[] array = new int[n];
        Arrays.fill(array, k);
        int index = 1;
        //一直循环
        while (true) {
            int nn = array[index];
            //将这个为此时为0
            array[index] = 0;
            while (nn > 0) {
                array[(++index) % (n)] += 1;
                nn--;
            }
            if (array[(index + 1) % (n)] == 0) {
                return array;
            } else {
                index = (index + 1) % (n);
            }
        }
    }

    private static int Rand(int n) {
        int max = n - 1;
        int min = 0;
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;
    }
}

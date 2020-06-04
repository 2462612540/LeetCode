/**
 * Copyright (C), 2018-2020
 * FileName: Main2
 * Author:   xjl
 * Date:     2020/5/7 7:53
 * Description: 输入输出测试
 */
package CodingTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] array = new int[n];
            HashMap<String, Integer> ha = new HashMap<>();
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            for (int j = 0; j < m; j++) {
                String str = sc.next();

                if (ha.containsKey(str)) {
                    ha.put(str, ha.get(str) + 1);
                } else {
                    ha.put(str, 1);
                }
            }
            Arrays.sort(array);
            int[] shanping = new int[ha.size()];
            int t = 0;
            for (Map.Entry<String, Integer> entry : ha.entrySet()) {
                int temp = entry.getValue();
                shanping[t] = temp;
                t++;
            }
            Arrays.sort(shanping);
            int b = 0;
            int summin = 0;
            for (int k = shanping.length - 1; k >= 0; k--) {
                summin += shanping[k] * array[b];
                b++;
            }
            int c = n - 1;
            int summax = 0;
            for (int k = shanping.length - 1; k >= 0; k--) {
                summax += shanping[k] * array[c];
                c--;
            }
            System.out.println(summin + "  " + summax);
        }
    }
}

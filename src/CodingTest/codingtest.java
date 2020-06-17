/**
 * Copyright (C), 2018-2020
 * FileName: codingtest
 * Author:   xjl
 * Date:     2020/5/7 15:25
 * Description: 测试
 */
package CodingTest;

import java.util.*;

public class codingtest {
    /**
     * 每行输入不等数量的参数 下面每一行都是存储的是的字符串
     * 4
     * 1 2
     * 2 0
     * 1 12
     */
    public static void test6() {
        Scanner sc = new Scanner(System.in);
        //一共几行
        int m = sc.nextInt();
        sc.nextLine();  // 很重要，跳到第二行
        //字符串数组
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int x_sum = 0;
        int y_sum = 0;
        ArrayList<Integer> list1 = new ArrayList<>();//表示的x正方向
        ArrayList<Integer> list2 = new ArrayList<>();//表示的y正方向
        ArrayList<Integer> list3 = new ArrayList<>();//表示的x负方向
        ArrayList<Integer> list4 = new ArrayList<>();//表示的y负方向

        // 从第二行开始读取  存取的是的String类型的数组
        for (int i = 0; i < m; i++) {
            String[] s = sc.nextLine().split(" ");
            int a = Integer.valueOf(s[0]);
            int b = Integer.valueOf(s[1]);
            if (a == 1) {
                list1.add(b);
                x_sum += b;
            }
            if (a == -1) {
                list2.add(b);
                x_sum -= b;
            }
            if (a == 2) {
                list3.add(b);
                y_sum += b;
            }
            if (a == -2) {
                list4.add(b);
                y_sum -= b;
            }
            //存储好数据
            map.put(1, list1);
            map.put(-1, list2);
            map.put(2, list3);
            map.put(-2, list4);
        }
    }
}

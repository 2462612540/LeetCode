/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/4/9 19:44
 * Description: 测试
 */
package AlibabbaTest;

import java.util.Scanner;

public class Main {

    public static void test(int x, String times, int min) {
        int res = x;
        String restime = "";
        int total = Integer.valueOf(times.split(":")[0]) * 60 + Integer.valueOf(times.split(":")[1]);
        //如果是min<total的时候则表示的还是在星期三
        if (total > min) {
            int h = (total - min) / 60;
            if (h < 10) {
                restime = "0" + String.valueOf(h) + ":" + String.valueOf((total - min) % 60);
                System.out.println(res);
                System.out.println(restime);
            } else {
                restime = String.valueOf(h) + ":" + String.valueOf((total - min) % 60);
                System.out.println(res);
                System.out.println(restime);
            }
        }
        //否是就是在以前了
        else {
            //计算的是多了多少个小时
            //多了天数
            int x1 = (min - total) / (24 * 60);
            //多了的小时数
            int h = ((min - total) - x1 * 24 * 60) / 60;
            //多了多少分钟
            int m = (min - total) % 60;

        }

    }

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        // 读取输入，直到没有整型数据可读
        while (cin.hasNextInt()) {
            // 读取接下来M行
            for (int i = 0; i < 3; i++) {
                // 读取每行的a b c
                int x = cin.nextInt();
                String time = cin.nextLine();
                int min = cin.nextInt();
                System.out.println(String.format(x + "---" + time + "----" + min));
            }
        }
    }
}

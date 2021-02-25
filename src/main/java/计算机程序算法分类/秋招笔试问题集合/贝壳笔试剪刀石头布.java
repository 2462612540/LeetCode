/**
 * Copyright (C), 2018-2020
 * FileName: 贝壳笔试剪刀石头布
 * Author:   xjl
 * Date:     2020/9/7 15:05
 * Description:
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.Scanner;

public class 贝壳笔试剪刀石头布 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int T = sc.nextInt();
            sc.nextLine();
            String[] s = sc.nextLine().trim().split(" ");
            String[] array1 = new String[2];
            String[] array2 = new String[2];
            array1[0] = s[0];
            array1[1] = s[1];
            array2[0] = s[2];
            array2[1] = s[3];
            //左手
            int count = 0;
            switch (array1[0]) {
                case "J":
                    switch (array2[0]) {
                        case "J":
                            count--;
                            break;
                        case "S":
                            count--;
                            break;
                        case "B":
                            count++;
                            break;
                    }
                    break;
                case "s":
                    switch (array2[0]) {
                        case "J":
                            count++;
                            break;
                        case "S":
                            count--;
                            break;
                        case "B":
                            count--;
                            break;

                    }
                    break;
                case "B":
                    switch (array2[0]) {
                        case "J":
                            count--;
                            break;
                        case "S":
                            count++;
                            break;
                        case "B":
                            break;
                    }
                    break;
            }
            //右手
            int count1 = 0;
            switch (array1[1]) {
                case "J":
                    switch (array2[1]) {
                        case "J":
                            count1--;
                            break;
                        case "S":
                            count1--;
                            break;
                        case "B":
                            count1++;
                            break;
                    }
                    break;
                case "s":
                    switch (array2[1]) {
                        case "J":
                            count1++;
                            break;
                        case "S":
                            count1--;
                            break;
                        case "B":
                            count1--;
                            break;

                    }
                    break;
                case "B":
                    switch (array2[1]) {
                        case "J":
                            count1--;
                            break;
                        case "S":
                            count1++;
                            break;
                        case "B":
                            count1--;
                            break;
                    }
                    break;
            }//左手
            //左手

            //右手

            //相同

        }
    }
}

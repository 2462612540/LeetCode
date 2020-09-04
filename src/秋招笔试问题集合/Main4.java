/**
 * Copyright (C), 2018-2020
 * FileName: Main4
 * Author:   xjl
 * Date:     2020/7/17 20:12
 * Description: ceshi
 */
package 秋招笔试问题集合;

import java.util.*;

class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //一行
        String str = sc.nextLine();
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > 'z' || str.charAt(i) < 'A') {
                res += ";";
            }else {
                res += str.charAt(i);
            }
        }
        String[] array = res.split(";");
        //结果输出
        for (int i = 0; i < array.length; i++) {
            if (!(array[i] == " ")) {
                System.out.println(array[i]);
            }
        }

    }
}

/**
 * Copyright (C), 2018-2020
 * FileName: Main7
 * Author:   xjl
 * Date:     2020/7/29 14:57
 * Description: 种草
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        //数据的输入
        Scanner sc = new Scanner(System.in);
        //小草的个数
        int n = sc.nextInt();
        //魔法个数
        int m = sc.nextInt();
        //长搞的高度
        int x = sc.nextInt();
        //赋值操作
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        //函数的调用
        while (m>0){
            Integer min = Collections.min(list);
            list.remove(Collections.min(list));
            list.add(min+x);
            m--;
        }
        //结果的打印
        System.out.println((int)Collections.min(list));
    }
}

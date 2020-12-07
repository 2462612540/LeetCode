/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 秋招笔试问题集合;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 糕点 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n<2){
                System.out.println("NO");
            }
            int m = sc.nextInt();
            if (m==0){
                System.out.println("YES");
            }
            int a = sc.nextInt();
            int b = sc.nextByte();
            if (a<b){
                int tmp=a;
                a=b;
                b=tmp;
            }
            if (n>=m+3){
                System.out.println("YES");
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                list.add(sc.nextInt());
            }
            if (n == m) {
                //就是比较数组的最大和最小的值 是否等于ab
                if (b ==Collections.min(list) && a ==Collections.max(list)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else if (n==m+1){
                //判断是最大和最小的是否等于a b
                if (Collections.min(list)==b||Collections.max(list)==a){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }else  if (n==m+2){
                list.add(a);
                list.add(b);
                if (a ==Collections.max(list) &&b ==Collections.min(list)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}

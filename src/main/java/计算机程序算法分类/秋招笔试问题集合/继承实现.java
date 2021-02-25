/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 计算机程序算法分类.秋招笔试问题集合;

public class 继承实现 {
    class base {
        public void printA() {
            System.out.println("baseA");
        }

        public void printB() {
            System.out.println("Base B");
        }

        public void printAB() {
            printA();
            printB();
        }
    }

}



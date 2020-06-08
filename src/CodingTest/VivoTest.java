/**
 * Copyright (C), 2018-2020
 * FileName: VivoTest
 * Author:   xjl
 * Date:     2020/6/7 16:53
 * Description: 测试
 */
package CodingTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VivoTest {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        //输入
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int number = sc.nextInt();
            int[] array = new int[number];
            for (int i = 0; i < array.length; i++) {
                array[i] = sc.nextInt();
            }

            //调用函数
            int result = test1(array);
            //输出结果
            System.out.println(result);
        }
    }

    //题目一
    private static int test0(int[] array) {
        int count = 0;
        int i = 0;
        while (i < array.length) {
            //只能允许三种情况出现的种花的情况
            if (array[i] == 0 && (i == 0 || array[i - 1] == 0) && (i == array.length - 1 || array[i + 1] == 0)) {
                array[i] = 1;
                count++;
            }
            i++;
        }
        return count;
    }

    //题目一
    private static int test1(int[] array) {
        if (array.length == 1) {
            if (array[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int count = 0, i = 0;
        while (i < array.length) {
            if (array[i] == 0) {
                if (i == 0) {
                    if (array[i + 1] == 0) {
                        array[i] = 1;
                        count++;
                    }
                } else if (i == array.length - 1) {
                    if (array[i - 1] == 0) {
                        array[i] = 1;
                        count++;
                    }
                } else if (i > 0 && i < array.length - 1) {
                    if ((array[i - 1] == 0 && array[i + 1] == 0)) {
                        array[i] = 1;
                        count++;
                    }
                }
            }
            i++;
        }
        return count;
    }

    private static void testIO() {

    }

    private static int test2() {
        return 2;
    }

    //多条链表的合并 题目三
    private static ListNode test3() {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();  // 很重要，跳到第二行
        String[] strArr = new String[m];
        List<Integer> list = new ArrayList<>();

        // 从第二行开始读取
        for (int i = 0; i < m; i++) {
            strArr[i] = sc.nextLine();
            String[] array = strArr[i].split(" ");
            for (int j = 0; j < array.length; j++) {
                //System.out.println(array[j]);
                list.add(Integer.valueOf(array[j]));
            }
        }

        //排序
        Collections.sort(list);

        //建立头结点
        ListNode listNode = new ListNode(0);
        ListNode curr = listNode;

        for (int v : list) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return listNode.next;
    }

    //定义链表
    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

/**
 * Copyright (C), 2018-2020
 * FileName: Main7
 * Author:   xjl
 * Date:     2020/7/10 16:35
 * Description: 给定一个无序单链表，实现单链表的选择排序(按升序排序)。
 */
package Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Main7 {
    public static void main(String[] args) {
        ListNode root = test();
        while (root != null) {
            System.out.print(root.val+" ");
            root = root.next;
        }
    }

    public static ListNode test() {
        //数据的输入
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(sc.nextInt());
        }
        //函数的调用
        Collections.sort(list);
        ListNode root = new ListNode(0);
        ListNode cur = root;
        for (int V : list) {
            cur.next = new ListNode(V);
            cur = cur.next;
        }
        return root.next;
    }
}

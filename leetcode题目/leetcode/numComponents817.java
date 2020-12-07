/**
 * Copyright (C), 2018-2020
 * FileName: numComponents817
 * Author:   xjl
 * Date:     2020/8/13 13:37
 * Description: 817. 链表组件
 */
package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class numComponents817 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int numComponents2(ListNode head, int[] G) {
        Set<Integer> Gset = new HashSet();
        for (int x : G) Gset.add(x);
        ListNode cur = head;
        int ans = 0;
        while (cur != null) {
            if (Gset.contains(cur.val) && (cur.next == null || !Gset.contains(cur.next.val)))
                ans++;
            cur = cur.next;
        }
        return ans;
    }

    public int numComponents(ListNode head, int[] G) {
        List<Integer> list = new ArrayList<>();
//        List<Integer> temp = new ArrayList<>();
        //存放数组中国的节点
        for (int i = 0; i < G.length; i++) {
            list.add(G[i]);
        }
        int result = 0;
        int flag = 0;
        while (head != null) {
            if (list.contains(head.val)) {
                list.remove((Object) head.val);
                flag = 1;
            } else if (list.isEmpty()) {
                break;
            } else {
                if (flag == 1) {
                    result++;
                    flag = 0;
                }
            }
            head = head.next;
        }
        if (flag == 1) {
            result++;
        }
        return result;
    }

    public int numComponents1(ListNode head, int[] G) {
        List<Integer> list = new ArrayList<>();
        //存放数组中国的节点
        for (int i = 0; i < G.length; i++) {
            list.add(G[i]);
        }
        int result = 0;
        int flag = 0;

        while (head != null) {
            if (list.contains(head.val)) {
                flag = 1;
            }
            if (flag == 1 && (!list.contains(head.val) || head.next == null)) {
                result++;
                flag = 0;
            }
            head = head.next;
        }
        return result;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(0);
        ListNode s2 = new ListNode(1);
        ListNode s3 = new ListNode(2);
        ListNode s4 = new ListNode(3);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;

        int[] array = {0, 3, 1};

        int i = numComponents1(s1, array);
        System.out.println(i);

    }
}

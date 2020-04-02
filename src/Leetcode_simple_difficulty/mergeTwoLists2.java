/**
 * Copyright (C), 2018-2020
 * FileName: mergeTwoLists2
 * Author:   xjl
 * Date:     2020/4/2 11:11
 * Description: 合并或立案表
 */
package Leetcode_simple_difficulty;

import org.junit.Test;

public class mergeTwoLists2 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode curr = node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr=l1;
                curr=curr.next;
                l1=l1.next;
            } else {
               curr=l2;
               curr=curr.next;
               l2=l2.next;
            }
            if (l1== null) {
               curr.next=l2;
            }
            if (l2 == null) {
               curr.next=l1;
            }
        }
        return node.next;
    }

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;

        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(3);
        ListNode m3 = new ListNode(4);
        m1.next = m2;
        m2.next = m3;

        ListNode res = mergeTwoLists(n1, m1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}

/**
 * Copyright (C), 2018-2020
 * FileName: addTwoNumbers3
 * Author:   xjl
 * Date:     2020/3/31 12:57
 * Description: 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 */
package Leetcode_Medium_difficulty;

import org.junit.Test;

public class addTwoNumbers3 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 另两个链表的相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //定义一个新的链表
        ListNode n = new ListNode(0);
        ListNode head=n;
        int curr = 0;
        while (l1 != null || l1 != null) {
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int sum = a + b + curr;
            curr = sum % 10;
            ListNode node = new ListNode(sum / 10);
            head.next = node;
            head = node;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (curr == 1) {
            head.next = new ListNode(1);
        }
        return head;
    }

    @Test
    public void test() {
        //链表1
        ListNode L1 = new ListNode(1);
        ListNode s2 = new ListNode(4);
        ListNode s3 = new ListNode(5);
        L1.next = s2;
        s2.next = s3;
        //链表2
        ListNode L2 = new ListNode(1);
        ListNode m2 = new ListNode(4);
        ListNode m3 = new ListNode(1);
        L2.next = m2;
        m2.next = m3;

       ListNode n = addTwoNumbers(L1, L2);
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

}

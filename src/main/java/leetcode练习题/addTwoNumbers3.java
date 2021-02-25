/**
 * Copyright (C), 2018-2020
 * FileName: addTwoNumbers3
 * Author:   xjl
 * Date:     2020/3/31 12:57
 * Description: 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 */
package leetcode练习题;

import org.junit.Test;

public class addTwoNumbers3 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode resultListNode = head;
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
                if (head == null) {
                    break;
                }
            }
        }
        if (resultListNode.val == val) {
            return resultListNode.next;
        }
        return resultListNode;
    }

    @Test
    public void test2() {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(6);
        ListNode s3 = new ListNode(3);
        ListNode s4 = new ListNode(2);
        ListNode s5 = new ListNode(6);
        ListNode s6 = null;

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        s5.next = s6;

        int target = 6;
        ListNode newnode = removeElements(s1, target);

        while (newnode != null) {
            System.out.println(newnode.val);
            newnode = newnode.next;
        }
    }
}

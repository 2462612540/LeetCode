/**
 * Copyright (C), 2018-2020
 * FileName: deleteDuplicates82
 * Author:   xjl
 * Date:     2020/6/29 11:09
 * Description: 82. 删除排序链表中的重复元素 II
 */
package leetcode;

import org.junit.Test;

public class deleteDuplicates82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        ListNode curr = head;

        while (curr != null) {

            if (curr.next != null && curr.val == curr.next.val) {
                while (curr.next != null && curr.val == curr.next.val) {
                    curr = curr.next;
                }
                curr = curr.next;
                pre.next = curr;
            } else {
                pre = pre.next;
                curr = curr.next;
            }
        }
        return node.next;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(1);
        ListNode s3 = new ListNode(1);
        ListNode s4 = new ListNode(3);
        ListNode s5 = new ListNode(3);
        ListNode s6 = new ListNode(5);
        ListNode s7 = new ListNode(1);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        s5.next = s6;
        s6.next = s7;

        ListNode listNode = deleteDuplicates(null);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

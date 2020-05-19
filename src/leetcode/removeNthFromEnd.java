/**
 * Copyright (C), 2018-2020
 * FileName: removeNthFromEnd
 * Author:   xjl
 * Date:     2020/3/28 11:33
 * Description: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
package leetcode;

import org.junit.Test;

public class removeNthFromEnd {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;

        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(3);
        ListNode s4 = new ListNode(4);
        ListNode s5 = new ListNode(5);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        int n = 2;
        removeNthFromEnd(s1, n);
    }

}

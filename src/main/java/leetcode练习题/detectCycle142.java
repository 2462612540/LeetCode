/**
 * Copyright (C), 2018-2020
 * FileName: detectCycle142
 * Author:   xjl
 * Date:     2020/5/26 9:23
 * Description: 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
package leetcode练习题;

import org.junit.Test;

public class detectCycle142 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(3);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(0);
        ListNode s4 = new ListNode(-4);
        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s2;

        ListNode listNode = detectCycle(s1);
        System.out.println(listNode.val);
    }
}

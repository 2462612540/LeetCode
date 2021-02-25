/**
 * Copyright (C), 2018-2020
 * FileName: removeElements203
 * Author:   xjl
 * Date:     2020/6/29 9:21
 * Description: 删除链表中等于给定值 val 的所有节点。
 */
package leetcode练习题;

import org.junit.Test;

public class removeElements203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(0);
        node.next = head;

        ListNode prev = node;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return node.next;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(6);
        ListNode s4 = new ListNode(3);
        ListNode s5 = new ListNode(4);
        ListNode s6 = new ListNode(5);
        ListNode s7 = new ListNode(1);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        s5.next = s6;
        s6.next = s7;

        ListNode listNode = removeElements(s1, 1);
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

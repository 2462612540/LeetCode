/**
 * Copyright (C), 2018-2020
 * FileName: addTwoNumbers2
 * Author:   xjl
 * Date:     2020/7/1 14:02
 * Description: 两个链表，代表两个整数的逆序，返回一个链表，代表两个整数相加和的逆序。
 */
package LinkList;

import org.junit.Test;

/**
 * leetcode 的两个链表的相加
 * (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class addTwoNumbers2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode test11(ListNode head) {
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;

        ListNode pre = dumpy;
        ListNode curr = head;

        while (curr.next != null) {
            ListNode furtue = curr.next;
            curr.next = furtue.next;
            furtue.next = pre.next;
            pre.next = furtue;
        }
        return dumpy.next;
    }

    /**
     * 两个链表的相加
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode s1 = l1;
        ListNode s2 = l2;

        ListNode node = new ListNode(0);
        ListNode result = node;
        int curr = 0;

        while (s1 != null || s2 != null) {
            int a = s1 != null ? s1.val : 0;
            int b = s2 != null ? s2.val : 0;
            int sum = a + b + curr;
            int val = sum % 10;
            curr = sum / 10;
            result.next = new ListNode(val);
            result = result.next;

            if (s1 != null) {
                s1 = s1.next;
            }
            if (s2 != null) {
                s2 = s2.next;
            }
        }
        if (curr == 1) {
            result.next = new ListNode(curr);
        }
        return node.next;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(7);
        ListNode s2 = new ListNode(1);
        ListNode s3 = new ListNode(6);

        ListNode s5 = new ListNode(5);
        ListNode s6 = new ListNode(9);
        ListNode s7 = new ListNode(2);

        s1.next = s2;
        s2.next = s3;

        s5.next = s6;
        s6.next = s7;

        ListNode listNode = addTwoNumbers(s1, s5);

        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

}

/**
 * Copyright (C), 2018-2020
 * FileName: addTwoNumbers2
 * Author:   xjl
 * Date:     2020/3/27 19:55
 * Description: 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。  如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package Leetcode_Medium_difficulty;

import org.junit.Test;

public class addTwoNumbers2 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        int cur = 0;
        while (l1 != null && l2 != null) {
            //当两个都不为空的时候
            int sum = l1.val + l2.val + cur;
            cur = sum / 10;
            ListNode node = new ListNode(sum % 10);
            pre.next = node;
            l1 = l1.next;
            l2 = l2.next;
            pre = pre.next;
        }

        if (cur == 1) {
            ListNode node = new ListNode(1);
            pre.next = node;
        }
        return pre;
    }

    @Test
    public void test() {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        ListNode m1 = new ListNode(5);
        ListNode m2 = new ListNode(6);
        ListNode m3 = new ListNode(4);
        m1.next = m2;
        m2.next = m3;

        ListNode head = addTwoNumbers(n1, m1);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}

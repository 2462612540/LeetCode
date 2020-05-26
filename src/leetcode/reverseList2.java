/**
 * Copyright (C), 2018-2020
 * FileName: reverseList2
 * Author:   xjl
 * Date:     2020/3/28 13:01
 * Description: 反转一个单链表。
 */
package leetcode;

import org.junit.Test;

public class reverseList2 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        //定义好一个空节点 w作为末尾的节点
        ListNode pre = null;
        //定义一个当前节点
        ListNode curr = head;
        while (curr != null) {
            //记录好当前的下一个节点
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = null;

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode s = reverseList(n1);
        while (s != null) {
            System.out.println(s.val);
            s = s.next;
        }
    }

}

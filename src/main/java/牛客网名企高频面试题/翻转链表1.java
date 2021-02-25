package 牛客网名企高频面试题;

/**
 * Copyright (C), 2018-2020
 * FileName: 链表的翻转1
 * Author:   xjl
 * Date:     2020/9/13 16:47
 * Description:
 */

public class 翻转链表1 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 第一种的遍历方式
     *
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public ListNode reverse2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dumy = new ListNode(0);
        dumy.next = head;

        ListNode pre = dumy;
        ListNode curr = head;

        while (curr.next != null) {
            ListNode furture = curr.next;
            curr.next = furture.next;
            furture.next = dumy.next;
            pre.next = furture;
        }

        return dumy.next;
    }

}

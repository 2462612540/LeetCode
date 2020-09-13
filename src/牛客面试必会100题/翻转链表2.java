/**
 * Copyright (C), 2018-2020
 * FileName: 翻转链表2
 * Author:   xjl
 * Date:     2020/9/13 18:12
 * Description:
 */
package 牛客面试必会100题;

public class 翻转链表2 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseLink(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dumy = new ListNode(0);
        dumy.next = head;

        ListNode pre = dumy;
        ListNode curr = head;

        while (curr.next != null) {
            ListNode future = curr.next;
            curr.next = future.next;
            future.next = dumy.next;
            pre.next = future;
        }
        return dumy.next;
    }
}

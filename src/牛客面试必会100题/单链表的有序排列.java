/**
 * Copyright (C), 2018-2020
 * FileName: 单链表的有序排列
 * Author:   xjl
 * Date:     2020/9/30 21:15
 * Description:
 */
package 牛客面试必会100题;

public class 单链表的有序排列 {

    public class ListNode {
        int val;
        ListNode next;
    }

    public ListNode sortInList (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //查分链表
        ListNode sec = slow.next;
        slow.next = null;
        //拆分
        ListNode node2 = sortInList(head);
        ListNode node1 = sortInList(sec);
        //合并链表
        ListNode res = merge(node1, node2);
        return res;
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dumpy = new ListNode();
        ListNode curr = dumpy;
        ListNode head1 = node1;
        ListNode head2 = node2;
        while (head1 != null && head2 != null) {
            if (head1.val >= head2.val) {
                curr.next = head2;
                head2 = head2.next;
            } else {
                curr.next = head1;
                head1 = head1.next;
            }
            curr = curr.next;
        }
        while (head1 != null) {
            curr.next = head1;
            head1 = head1.next;
            curr = curr.next;
        }
        while (head2 != null) {
            curr.next = head2;
            curr = curr.next;
            head2 = head2.next;
        }
        return dumpy.next;
    }
}

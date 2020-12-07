package 名企高频面试题143;

/**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.指定链表的区间翻转
 * Author:   xjl
 * Date:     2020/10/1 12:38
 * Description:
 */


public class 指定链表的区间翻转 {
    public class ListNode {
        int val;
        ListNode next = null;
    }

    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if (head == null) return head;
        ListNode dumpy = new ListNode();
        dumpy.next = head;

        ListNode pre = dumpy;//第一段最后的一个节点
        //找到第m个节点
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;

        for (int i = m; i < n; i++) {
            ListNode future = cur.next;
            cur.next = future.next;
            future.next = pre.next;
            pre.next = future;
        }
        return dumpy.next;
    }
}

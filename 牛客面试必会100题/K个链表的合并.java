/**
 * Copyright (C), 2018-2020
 * FileName: K个链表的合并
 * Author:   xjl
 * Date:     2020/9/14 12:27
 * Description:
 */

import java.util.ArrayList;

public class K个链表的合并 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) return null;
        ListNode res = lists.get(0);
        for (int i = 1; i < lists.size(); i++) {
            res = mergeTwoLists(lists.get(i), res);
        }
        return res;
    }

    //已经排序的链表的排序
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 创建一个新的链表
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return pre.next;
    }
}

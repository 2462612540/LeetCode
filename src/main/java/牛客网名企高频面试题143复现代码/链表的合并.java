package 牛客网名企高频面试题143复现代码;

import java.util.ArrayList;

/**
 * @Classname 链表的合并
 * @Description TODO
 * @Date 2020/12/22 15:29
 * @Created by xjl
 */
public class 链表的合并 {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) return null;
        ListNode res = lists.get(0);
        for (int i = 1; i < lists.size(); i++) {
            res = mergeTwoLists(lists.get(i), res);
        }
        return res;
    }

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

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        /**
         * @description TODO 合并链表
         * @param: lists
         * @date: 2020/12/22 15:30
         * @return: 复现代码.链表的合并.ListNode
         * @author: xjl
         */
        public ListNode merge(ArrayList<ListNode> lists) {
            if (lists.size() == 0) {
                return null;
            }
            ListNode res = lists.get(0);
            for (int i = 1; i < lists.size(); i++) {
                res = mergeTwoLists(lists.get(i), res);
            }
            return res;
        }

        private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
            ListNode curr1 = head1;
            ListNode curr2 = head2;

            ListNode res = new ListNode(0);
            ListNode dumpy = res;

            while (curr1 != null && curr2 != null) {
                if (curr1.val > curr2.val) {
                    dumpy.next = curr2;
                    curr2 = curr2.next;
                } else {
                    dumpy.next = curr1;
                    curr1 = curr1.next;
                }
                dumpy = dumpy.next;
            }
            if (curr1 != null) {
                dumpy.next = curr1;
            }
            if (curr2 != null) {
                dumpy.next = curr2;
            }
            return res.next;
        }
    }
}

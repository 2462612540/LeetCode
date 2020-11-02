/**
 * Copyright (C), 2018-2020
 * FileName: AndLinklist
 * Author:   xjl
 * Date:     2020/8/12 9:48
 * Description: 合并有序的链表
 */
package leetcode;

public class AndLinklist {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 单链表的翻转
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        //设置新的节点
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;

        ListNode pre = dumpy;
        ListNode cur = head;

        while (cur.next != null) {
            ListNode future = cur.next;
            cur.next = future.next;
            future.next = pre.next;
            pre.next = future;
        }
        return dumpy.next;
    }

    /**
     * 单链表的翻转
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
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

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * <p>
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head;
        ListNode dumpy = new ListNode(-1);
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

    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        //设置新的节点 可能次那个第一位置开始
        ListNode dump = new ListNode(-1);
        dump.next = head;

        ListNode pre = dump;
        //找到第m个节点的位置
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;

        for (int i = m; i < n; i++) {
            ListNode future = cur.next;
            //开始翻转
            cur.next = future.next;
            future.next = pre.next;
            pre.next = future;
        }
        return dump.next;
    }

    /**
     * 链表的实现有序排列
     * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //使用快慢指针
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        //递归的去拆分
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        //合并链表
        ListNode result = mergeTwoLists(left, right);
        return result;
    }

    /**
     * 链表和合并  输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 创建一个新的链表
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
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
        return dummyHead.next;
    }

}

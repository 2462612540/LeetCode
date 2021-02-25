package 牛客网名企高频面试题143;

/**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.指定区间链表翻转
 * Author:   xjl
 * Date:     2020/9/16 14:46
 * Description:
 */


public class 指定区间链表翻转 {

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 将一个链表 m\ m m 位置到 n\ n n 位置之间的区间反转，要求时间复杂度 ，空间复杂度 。
     * 例如：
     * 给出的链表为 1→2→3→4→5→NULL1\to 2 \to 3 \to 4 \to 5 \to NULL1→2→3→4→5→NULL, ，,
     * 返回 1→4→3→2→5→NULL1\to 4\to 3\to 2\to 5\to NULL1→4→3→2→5→NULL.
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;

        ListNode frist = dumpy;
        int a = m - 1;
        while (a > 0) {
            frist = frist.next;
            a--;
        }
        ListNode node = frist.next;
        frist.next = null;

        ListNode second = node;
        int num = n - m;
        while (num > 0) {
            second = second.next;
            num--;
        }
        ListNode node1 = second.next;
        second.next = null;
        //合起来
        ListNode res = reverse(node);
        ListNode next = res;

        while (next.next != null) {
            next = next.next;
        }
        frist.next = res;
        next.next = node1;
        return dumpy.next;
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode future = curr.next;
            curr.next = pre;
            pre = curr;
            curr = future;
        }
        return pre;
    }

    /**
     * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * <p>
     * 说明:
     * 1 ≤ m ≤ n ≤ 链表长度。
     */
    public ListNode reverseBetween1(ListNode head, int m, int n) {
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

    public static void main(String[] args) {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(3);
        ListNode s4 = new ListNode(4);
        ListNode s5 = new ListNode(5);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;

        ListNode listNode = reverseBetween(s1, 2, 4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

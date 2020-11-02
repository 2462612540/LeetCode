/**
 * Copyright (C), 2018-2020
 * FileName: rotateRight61
 * Author:   xjl
 * Date:     2020/8/13 9:57
 * Description: 旋转链表
 */
package leetcode;

/**
 * 采用的思想还是的快慢的指针这样的一种的方法
 */
public class rotateRight61 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 采用的是的慢指针
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        //计算一下链表的长度
        ListNode curr = head;
        int n = 0;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        //当k的值大于的时候n的时候
        k = k % n;
        if (k == 0) {
            return head;
        }

        //让快的指针走动
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        //让指针都走到最后
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //断开和连接指针
        ListNode nhead = slow.next;
        fast.next = head;
        slow.next = null;
        return nhead;
    }
}

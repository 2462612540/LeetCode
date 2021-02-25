/**
 * Copyright (C), 2018-2020
 * FileName: partition86
 * Author:   xjl
 * Date:     2020/8/13 9:04
 * Description: 分割链表
 */
package leetcode练习题;

import org.junit.Test;

public class partition86 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
     * 你应当保留两个分区中每个节点的初始相对位置。
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition1(ListNode head, int x) {
        ListNode curr = head;
        //设置两个新的节点
        ListNode result1 = new ListNode(-1);
        ListNode s1 = result1;

        ListNode result2 = new ListNode(-1);
        ListNode s2 = result2;

        //遍历head的节点
        while (curr != null) {
            if (curr.val < x) {
                s1.next = curr;
                s1 = s1.next;
            } else {
                s2.next = curr;
                s2 = s2.next;
            }
            curr = curr.next;
        }
        //让s1的节点指向s2的下一个
        s1.next = result2.next;
        s2.next = null;
        return result1.next;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(4);
        ListNode s3 = new ListNode(3);
        ListNode s4 = new ListNode(2);
        ListNode s5 = new ListNode(5);
        ListNode s6 = new ListNode(2);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        s5.next = s6;

        ListNode listNode = partition1(s1, 3);

    }
}

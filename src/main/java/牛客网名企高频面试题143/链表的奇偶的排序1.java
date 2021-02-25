package 牛客网名企高频面试题143;

/**
 * Copyright (C), 2018-2020
 * FileName: 链表的的奇偶的排序
 * Author:   xjl
 * Date:     2020/10/5 18:16
 * Description:
 */

public class 链表的奇偶的排序1 {
    public class ListNode {
        int val;
        ListNode next = null;
    }

    /**
     * 思路是的遍历的这个链表的  采用的是的两个指针分别指向的是奇或者是偶数 来保证 最后的时候来实现的奇数的下一指向偶数的想一个
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode();
        ListNode even = new ListNode();

        ListNode curr1 = odd;//表示奇数
        ListNode curr2 = even;//表示偶数

        while (head != null) {
            if (head.val % 2 == 0) {
                curr2.next = head;
                curr2 = curr2.next;
                head = head.next;
            } else {
                curr1.next = head;
                curr1 = curr1.next;
                head = head.next;
            }
        }
        curr1.next = even.next;
        return odd.next;
    }
}

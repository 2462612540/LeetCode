/**
 * Copyright (C), 2018-2020
 * FileName: oddEvenList328
 * Author:   xjl
 * Date:     2020/8/13 14:54
 * Description: 328. 奇偶链表
 */
package leetcode;

import org.junit.Test;

public class oddEvenList328 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 两种方法就是的将设计两个链表的 然后在最后的串起来
     * 或者是的使用的两个队列的存储奇数和偶数的 然后在所以此遍历就好。
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode event = new ListNode(-1);

        ListNode pre = odd;
        ListNode curr = event;
        int number = 0;
        while (head != null) {
            if (number % 2 == 0) {
                pre.next = head;
                pre = pre.next;
            } else {
                curr.next = head;
                curr = curr.next;
            }
            head = head.next;
            number++;
        }
        pre.next = event.next;
        curr.next = null;
        return odd.next;
    }

    public ListNode oddEvenList2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenhead = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        //将节点反过来
        odd.next = evenhead;
        return head;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(3);
        ListNode s4 = new ListNode(4);
        ListNode s5 = new ListNode(5);
        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        ListNode listNode = oddEvenList(s1);
        while (listNode != null) {
            System.out.print(listNode.val + "--");
            listNode = listNode.next;
        }
    }

}

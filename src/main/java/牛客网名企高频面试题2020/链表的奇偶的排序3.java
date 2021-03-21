package 牛客网名企高频面试题2020; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.链表的奇偶的排序2
 * Author:   xjl
 * Date:     2020/10/5 18:37
 * Description:
 */

import org.junit.Test;

public class 链表的奇偶的排序3 {

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode oddEvenList(ListNode head) {
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
        ListNode s2 = new ListNode(4);
        ListNode s3 = new ListNode(6);
        ListNode s4 = new ListNode(3);
        ListNode s5 = new ListNode(7);
        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;

        ListNode ans = oddEvenList(s1);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }

}

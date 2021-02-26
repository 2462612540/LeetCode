package 牛客网名企高频面试题2020; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.链表的奇偶的排序2
 * Author:   xjl
 * Date:     2020/10/5 18:37
 * Description:
 */

import org.junit.Test;

public class 链表的奇偶的排序2 {

    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);

        ListNode curr1 = odd;//表示奇数
        ListNode curr2 = even;//表示偶数

        int count = 1;
        while (head != null) {
            if (count % 2 == 0) {
                curr2.next = head;
                curr2 = curr2.next;
            } else {
                curr1.next = head;
                curr1 = curr1.next;
            }
            head = head.next;
            count++;
        }
        curr1.next = null;
        curr2.next = null;
        curr1.next = even.next;
        return odd.next;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(4);
        ListNode s3 = new ListNode(6);
        ListNode s4 = new ListNode(3);
        ListNode s5 = new ListNode(7);
//        ListNode s6 = new ListNode(8);
        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
//        s5.next = s6;

        ListNode ans = oddEvenList(s1);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }

}

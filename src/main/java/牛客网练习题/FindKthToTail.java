/**
 * Copyright (C), 2018-2020
 * FileName: FindKthToTail
 * Author:   xjl
 * Date:     2020/5/8 19:48
 * Description: 输入一个链表，输出该链表中倒数第k个结点。
 */
package 牛客网练习题;

import org.junit.Test;

public class FindKthToTail {
    public class ListNode {
        public int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode curr=head;
        int cout = 0;
        while (head != null) {
            cout++;
            head = head.next;
        }
        int index = cout - k;
        System.out.println(index);
        while (curr != null) {
            if (index == 0) {
                return curr;
            }
            index--;
            curr = curr.next;
        }
        return null;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(3);
        ListNode s2 = new ListNode(4);
        ListNode s3 = new ListNode(5);
        ListNode s4 = new ListNode(6);
        ListNode s5 = new ListNode(7);
        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;

        int k = 2;
        System.out.println(FindKthToTail(s1, k).value);
    }
}

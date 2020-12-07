/**
 * Copyright (C), 2018-2020
 * FileName: 链表的数字相加1
 * Author:   xjl
 * Date:     2020/9/14 9:28
 * Description:
 */
package 牛客面试必会100题;

import org.junit.Test;

public class 链表的数字相加1 {
    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(9);
        ListNode s2 = new ListNode(3);
        ListNode s3 = new ListNode(7);
        s1.next = s2;
        s2.next = s3;
        ListNode s4 = new ListNode(6);
        ListNode s5 = new ListNode(3);
        s4.next = s5;
        ListNode ans = addInList(s1, s4);
        while (ans != null) {
            System.out.print(ans.val + "--");
            ans = ans.next;
        }
    }

    public ListNode addInList(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        } else if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        //链表翻转
        ListNode l1 = reverse(head1);
        ListNode l2 = reverse(head2);
        //链表相加
        ListNode ans = addInListtest(l1, l2);
        return ans;
    }

    private ListNode addInListtest(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;

        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        int count = 0;
        while (head1 != null || head2 != null) {
            int a = head1 != null ? head1.val : 0;
            int b = head2 != null ? head2.val : 0;
            int sum = a + b + count;
            count = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (head1 != null) {
                head1 = head1.next;
            }
            if (head2 != null) {
                head2 = head2.next;
            }
        }
        if (count == 1) {
            cur.next = new ListNode(1);
        }
        ListNode res = reverse(ans.next);
        return res;
    }

    private ListNode reverse(ListNode head) {
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
}

package 牛客网名企高频面试题复现代码;

import org.junit.Test;

/**
 * @Classname 翻转链表
 * @Description TODO
 * @Date 2020/12/21 14:04
 * @Created by xjl
 */
public class 反转链表III {
    public ListNode rev(ListNode head) {
        if (head == null) {
            return null;
        }
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

    public ListNode rev2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;

        ListNode pre = dumpy;
        ListNode curr = head;
        while (curr.next != null) {
            ListNode future = curr.next;
            curr.next = future.next;
            future.next = dumpy.next;
            pre.next = future;
        }
        return dumpy.next;
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

        ListNode res = rev2(s1);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

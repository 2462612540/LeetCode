package 牛客网名企高频面试题复现代码2020;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Classname 反转链表II
 * @Description TODO
 * @Date 2020/12/21 12:56
 * @Created by xjl
 */
public class 反转链表II {
    public ListNode rever(ListNode head) {
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

    public ListNode rever1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dumy = new ListNode(0);
        dumy.next = head;

        ListNode pre = dumy;
        ListNode curr = head;

        while (curr.next != null) {
            ListNode future = curr.next;
            curr.next = future.next;
            future.next = dumy.next;
            pre.next = future;
        }
        return dumy.next;
    }

    public ListNode reverlist(ListNode head) {
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

    public ListNode re(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode futre = curr.next;
            curr.next = pre;
            pre = curr;
            curr = futre;
        }
        return pre;
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

        ListNode res = re(s1);

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

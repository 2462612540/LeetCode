package 牛客网名企高频面试题复现代码2020;

import org.junit.Test;

/**
 * @Classname 删除链表的重复元素
 * @Description TODO
 * @Date 2020/12/21 15:06
 * @Created by xjl
 */
public class 删除链表的重复元素 {

    public ListNode delete(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public ListNode de(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode future = curr.next;
            if (future.val == curr.val) {
                curr.next = future.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(1);
        ListNode s3 = new ListNode(2);
        ListNode s4 = new ListNode(3);
        ListNode s5 = new ListNode(3);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;

        ListNode res = delete(s1);

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

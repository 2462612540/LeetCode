package 牛客网名企高频面试题;

import org.junit.Test;

/**
 * @Classname 划分链表
 * @Description TODO
 * @Date 2020/12/12 15:33
 * @Created by xjl
 */
public class 划分链表 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode dumpy1 = new ListNode(0);
        ListNode dumpy2 = new ListNode(0);
        ListNode samll = dumpy1;
        ListNode large = dumpy2;
        ListNode pre = head;

        while (pre != null) {
            if (pre.val < x) {
                samll.next = pre;
                samll = pre;
            } else {
                large.next = pre;
                large = pre;
            }
            pre = pre.next;
        }
        large.next = null;
        samll.next = dumpy2.next;
        return dumpy1.next;
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

        ListNode res = partition(s1, 3);
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

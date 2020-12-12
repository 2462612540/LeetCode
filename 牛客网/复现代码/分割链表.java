package 复现代码;

import org.junit.Test;

/**
 * @Classname 分割链表
 * @Description TODO
 * @Date 2020/12/12 16:24
 * @Created by xjl
 */
public class 分割链表 {
    public ListNode per(ListNode head, int x) {
        //检查安全
        if (head == null) return null;
        ListNode dumpy1 = new ListNode(0);
        ListNode dumpy2 = new ListNode(0);

        ListNode samll = dumpy1;
        ListNode large = dumpy2;
        ListNode pre = head;

        while (pre != null) {
            if (pre.val >= x) {
                large.next = pre;
                large = large.next;
            } else {
                samll.next = pre;
                samll = samll.next;
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

        ListNode res = per(s1, 3);
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

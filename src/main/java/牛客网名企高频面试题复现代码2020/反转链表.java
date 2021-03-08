package 牛客网名企高频面试题复现代码2020;

import org.junit.Test;

/**
 * @Classname 反转链表
 * @Description TODO
 * @Date 2020/12/20 21:29
 * @Created by xjl
 */
public class 反转链表 {
    /**
     * @description TODO  链表的翻转
     * @param: head
     * @date: 2020/12/20 21:52
     * @return: void
     * @author: xjl
     */
    public ListNode rever(ListNode head) {
        if (head == null) {
            return head;
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

        ListNode res = rever(s1);

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

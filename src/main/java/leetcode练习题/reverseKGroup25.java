/**
 * Copyright (C), 2018-2020
 * FileName: reverseKGroup25
 * Author:   xjl
 * Date:     2020/8/14 9:27
 * Description: 翻转k组
 */
package leetcode练习题;

import org.junit.Test;

public class reverseKGroup25 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 链表的翻转
     *
     * @param head
     */
    public ListNode revers(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;

            pre = curr;
            curr = next;
        }
        return pre;
    }

    public ListNode revers2(ListNode head) {
        if (head == null) return head;
        ListNode dump = new ListNode(-1);
        dump.next = head;

        ListNode pre = dump;
        ListNode curr = head;
        //三个步骤不能颠倒
        while (curr.next != null) {
            ListNode future = curr.next;
            curr.next = future.next;
            future.next = pre.next;
            pre.next = future;
        }
        return dump.next;
    }

    /**
     * K 组链表的翻转
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dumpy = new ListNode(0);
        dumpy.next = head;

        ListNode pre = dumpy;
        ListNode start = head;
        ListNode end = head;
        ListNode next = head;

        while (next != null) {
            //找到k个长度的 找到end
            for (int i = 1; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            //进行翻转
            //找到这个下一个链表的指针
            next = end.next;
            //断开这个前面的k个链表
            end.next = null;
            end = start;
            start = revers2(start);
            //连接起来
            end.next = next;
            pre.next = start;
            //重新制定的pre start end
            pre = end;
            start = next;
            end = start;
        }
        return dumpy.next;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(3);
        ListNode s4 = new ListNode(5);
        ListNode s5 = new ListNode(6);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;

        ListNode reverse = revers2(s1);
        while (reverse != null) {
            System.out.print(reverse.val + "--");
            reverse = reverse.next;
        }

    }
}

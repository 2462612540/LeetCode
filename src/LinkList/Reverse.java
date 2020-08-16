/**
 * Copyright (C), 2018-2020
 * FileName: Reverse
 * Author:   xjl
 * Date:     2020/8/15 9:17
 * Description: 单链表的翻转
 */
package LinkList;

import org.junit.Test;

public class Reverse {
    //节点的定义
    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode revese(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            //这个不能颠倒着顺序
            ListNode future = curr.next;
            curr.next = pre;
            pre = curr;
            curr = future;
        }
        return pre;
    }

    public ListNode revse(ListNode head) {
        ListNode dumpy = new ListNode(-1);
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

        ListNode result = revese(s1);

        while (result != null) {
            System.out.print(result.val + "--");
            result = result.next;
        }
    }
}

/**
 * Copyright (C), 2018-2020
 * FileName: 删除链表的倒数节点
 * Author:   xjl
 * Date:     2020/9/13 22:04
 * Description:
 */
package 牛客面试必会100题;

import org.junit.Test;

public class 删除链表的倒数节点 {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 保证时间复杂度是n
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //计算右多少个节点
        ListNode n1 = head;
        int count = 0;
        while (n1 != null) {
            count++;
            n1 = n1.next;
        }
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode curr = dumy;
        //在删除一个节点
        count = count - n;
        while (count > 0) {
            curr = curr.next;
            count--;
        }
        curr.next = curr.next.next;
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

        ListNode node = removeNthFromEnd(s1, 4);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

    }
}

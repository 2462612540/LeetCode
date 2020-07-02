/**
 * Copyright (C), 2018-2020
 * FileName: removeNthFromEnd19
 * Author:   xjl
 * Date:     2020/7/1 14:45
 * Description: 19. 删除链表的倒数第N个节点
 */
package LinkList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class removeNthFromEnd19 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //1将链表反转 后俩删除这个节点

        //2 利用的是list的集合删除后在将链表重建
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int index = list.size() - n;
        int i = 0;
        ListNode curr = new ListNode(0);
        ListNode res = curr;
        for (int val : list) {
            if (i++ == index) {
                continue;
            }
            res.next = new ListNode(val);
            res = res.next;
        }
        //3 先遍历在实现这个东西
        return curr.next;
    }

    /**
     * 采用的是双指针
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode frist = head;
        for (int i = 0; i < n; i++) {
            frist = frist.next;
        }
        if (frist == null) {
            return head.next;
        }
        ListNode second = head;
        while (frist.next != null) {
            frist = frist.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(3);
        ListNode s4 = new ListNode(4);
        ListNode s5 = new ListNode(5);
        ListNode s6 = new ListNode(6);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        s5.next = s6;

        ListNode listNode = removeNthFromEnd2(s1, 2);

        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }
}

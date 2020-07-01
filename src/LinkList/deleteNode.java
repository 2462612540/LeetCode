/**
 * Copyright (C), 2018-2020
 * FileName: deleteNode
 * Author:   xjl
 * Date:     2020/6/29 10:38
 * Description: 237. 删除链表中的节点
 */
package LinkList;

import org.junit.Test;

public class deleteNode {

    public void deleteNode(ListNode node) {

    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(6);
        ListNode s4 = new ListNode(3);
        ListNode s5 = new ListNode(4);
        ListNode s6 = new ListNode(5);
        ListNode s7 = new ListNode(1);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        s5.next = s6;
        s6.next = s7;

        deleteNode(s1);

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}

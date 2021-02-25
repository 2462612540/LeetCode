/**
 * Copyright (C), 2018-2020
 * FileName: FindFirstCommonNode
 * Author:   xjl
 * Date:     2020/5/9 12:47
 * Description: 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
package 牛客网练习题;

import org.junit.Test;

public class FindFirstCommonNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

    }

    //不做链表的翻转 利用栈的结构来实现
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        return null;
    }

    @Test
    public void test() {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(3);
        ListNode s4 = new ListNode(4);
        s1.next = s2;
        s2.next = s3;
        s3.next = s4;

        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(9);
        ListNode n5 = new ListNode(10);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode node = FindFirstCommonNode(s1, n1);
        System.out.println(node.val);

    }
}

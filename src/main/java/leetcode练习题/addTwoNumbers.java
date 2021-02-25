/**
 * Copyright (C), 2018-2020
 * FileName: addTwoNumbers
 * Author:   xjl
 * Date:     2020/3/9 8:50
 * Description: 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 */
package leetcode练习题;

import org.junit.Test;

public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        //进位符
        int carry = 0;
        while (l1 != null || l2 != null) {
            //如果是等于空的时候要选择为0数进行加减
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum=x + y + carry;
            carry=sum/10;
            int n =sum%10;
            //添加新的节点
            cur.next = new ListNode(n);
            //并将向下移动
            cur = cur.next;
            //分别在两个中进行下一个的操作
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

    @Test
    public void test() {
        //链表1
        ListNode L1 = new ListNode(2);
        ListNode s2 = new ListNode(4);
        ListNode s3 = new ListNode(3);
        L1.next = s2;
        s2.next = s3;
        //链表2
        ListNode L2 = new ListNode(5);
        ListNode m2 = new ListNode(6);
        ListNode m3 = new ListNode(4);
        L2.next = m2;
        m2.next = m3;
        //遍历第一个链表 这样就可以进项遍历所有的节点
//        while (L1 != null) {
//            System.out.println(L1.val);
//            L1 = L1.next;
//        }
        ListNode n = addTwoNumbers(L1, L2);
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

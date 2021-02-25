/**
 * Copyright (C), 2018-2020
 * FileName: addTwoNumbers4
 * Author:   xjl
 * Date:     2020/4/14 14:21
 * Description: 链表的操作
 */
package leetcode练习题;

import org.junit.Test;

import java.util.Stack;

public class addTwoNumbers4 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //将链表反转
        l1 = resver(l1);
        l2 = resver(l2);

        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        //进位符
        int carry = 0;
        while (l1 != null || l2 != null) {
            //取出两个数字来实现加减 保证如果为空那就是0 如果是不为空的话的那就是取出这个数字来
            //如果是等于空的时候要选择为0数进行加减
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            int n = sum % 10;
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
        return resver(pre.next);
    }

    public ListNode resver(ListNode head) {
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

    @Test
    public void test() {
        //链表1
        ListNode L1 = new ListNode(7);
        ListNode s2 = new ListNode(2);
        ListNode s3 = new ListNode(4);
        ListNode s4 = new ListNode(3);
        L1.next = s2;
        s2.next = s3;
        s3.next = s4;

        //链表2
        ListNode L2 = new ListNode(5);
        ListNode m2 = new ListNode(6);
        ListNode m3 = new ListNode(4);
        L2.next = m2;
        m2.next = m3;

        ListNode n = addTwoNumbers(L1, L2);

        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    //在求解的时候注意链表的相加的时候可以采用合适的栈和队列的数据来实现的加法
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }

}

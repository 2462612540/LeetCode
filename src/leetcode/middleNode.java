/**
 * Copyright (C), 2018-2020
 * FileName: middleNode
 * Author:   xjl
 * Date:     2020/3/30 12:17
 * Description: 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。  如果有两个中间结点，则返回第二个中间结点。
 */
package leetcode;

import org.junit.Test;

public class middleNode {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode re = head;
        int count = 0;
        //统计个数
        while (head != null) {
            count++;
            head = head.next;
        }
        //查看收有两个中点
        count = count / 2 + 1;
       for (int i=1;i<count;i++){
           re=re.next;
       }
        return re;
    }

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        System.out.println(middleNode(n1).val);
    }
}
